
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Attacco implements StatoAttacco{

    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(ClashGame clash) {
     ArrayList<Casella> listC =  clash.caselleDifensore();//recupero le caselle del difensore
        
        for(int i=0;i<listC.size();i++){//per ogni casella mi recupero l'edificio
            Edificio ed=listC.get(i).getEdificio();
            if(ed!=null){
                ArrayList<Casella> listaCaselleConEroiDaAttaccare=ed.getModA().attaccoEdificio(ed);//recupero la lista delle caselle con gli eroi da attaccare
                for(int j=0;j<listaCaselleConEroiDaAttaccare.size();j++){
                    
                    Casella c=listaCaselleConEroiDaAttaccare.get(j);
                    //System.out.print(c.getPosizioneColonna()+""+c.getPosizioneRiga()+" ");
                    ArrayList<Eroe> listE= listaCaselleConEroiDaAttaccare.get(j).getListaEroiA();
                    int k=0; 
                    while(k<listE.size()){
                        Eroe eroe=listE.get(k);
                        int vita=eroe.getStat().getVita();//VEDERE SE FARE UNA CLASSE O QUALCOSA PER LA REGOLA DI TOGLIMENTO VITA
                        int difesa=eroe.getStat().getDifesa()+eroe.getSkin().getDifesa();
                        int attaccoEdificio=ed.getStatistica().getAttacco();//+ la attacco della skin?
                        if(attaccoEdificio-difesa>5 &&vita>0){
                            int attdif=attaccoEdificio-difesa;
                            vita-=attdif;
                        }
                        else{
                            vita-=5;
                        }
                        if(vita<0){
                            vita=0;
                        }
                        if(vita>0){
                            eroe.setVita(vita);
                            k++;
                        }
                        else{
                            listE.remove(k);
                        }
                        
                        //listE.set(k, eroe);
                        
                    }
                        
                        
                    /*    
                    for(int k=0;k<listE.size();k++){
                        Eroe eroe=listE.get(k);
                        int vita=eroe.getStat().getVita();//VEDERE SE FARE UNA CLASSE O QUALCOSA PER LA REGOLA DI TOGLIMENTO VITA
                        int difesa=eroe.getStat().getDifesa()+eroe.getSkin().getDifesa();
                        int attaccoEdificio=ed.getStatistica().getAttacco();//+ la attacco della skin?
                        if(attaccoEdificio-difesa>5 &&vita>0){
                            int attdif=attaccoEdificio-difesa;
                            vita-=attdif;
                        }
                        else{
                            vita-=5;
                        }
                        if(vita<0){
                            vita=0;
                        }
                        eroe.setVita(vita);
                        //listE.set(k, eroe);
                        
                    }
                    */
                    //c.setListaEroiA(listE);
                   // i//nt vita1=c.getListaEroiA().get(0).getStat().getVita();
                    //clash.getGiocatoreD().getVillaggio().setCasella(c);
                   // listaCaselleConEroiDaAttaccare.set(j, c);
                    
                }
            }      
        }
        this.cambiaStato(clash,new ControlloFineBattaglia());
    }

    @Override
    public void attaccanoEroi(ClashGame clash) {
        ArrayList<Casella> listC =  clash.caselleDifensore(); //recupero le caselle del difensore      
        for(int i=0;i<listC.size();i++){   
            ArrayList<Eroe> eroi=listC.get(i).getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
            for(int j=0;j<eroi.size();j++){
                Eroe e=eroi.get(j);//recupero l'eroe
                ArrayList<Casella> listCaselleDaAttaccare=e.getModA().attacco(e);//recupero le caselle da attaccare  
                //int almenoUnEdificioAttaccato=0;.
                for(int k=0;k<listCaselleDaAttaccare.size();k++){
                     
                    //MANCA CONTROLLO SULLA VITA DELL'EDIFICIO
                    Casella c=listCaselleDaAttaccare.get(k);
                    Edificio edificio=listCaselleDaAttaccare.get(k).getEdificio();
                    if(edificio!=null){
                        int vita=edificio.getStatistica().getVita();
                        int difesa=edificio.getStatistica().getDifesa();//+ la difesa della skin?
                        int attaccoEroe=e.getStat().getAttacco()+e.getSkin().getAttacco();
                        if(attaccoEroe-difesa>5 &&vita>0){
                            //almenoUnEdificioAttaccato++;
                            int attdif=attaccoEroe-difesa; 
                            vita-=attdif;                           
                            //System.out.print(attaccoEroe+"CIAO1 "+vita+" difesa"+difesa);
                            //System.out.print(attdif+" "+vita);
                        }
                        else{
                            //System.out.print(attaccoEroe+"CIAO "+vita+"difesa"+difesa);
                           // almenoUnEdificioAttaccato++;
                            vita-=5;
                        }
                        if(vita<0){
                            vita=0;
                        }
                        edificio.setVita(vita);
                    } 
                }
              /*  if(almenoUnEdificioAttaccato>0){//non serve
                    almenoUnEdificioAttaccato=0;
                    this.cambiaStato(clash, new AttaccanoEdifici());
                }*/
            }     
        }
       // this.cambiaStato(clash, new AttaccanoEdifici());//cambio stato 
       this.cambiaStato(clash, new ControlloFineBattaglia());

    }
    
    //sposta
    @Override
    public void spostaEroi(ClashGame clash) {
    
        ArrayList<Casella> listC =  clash.caselleDifensore(); //recupero le caselle del difensore
        for(int i=0;i<listC.size();i++){
            Casella casellaCorrente=listC.get(i);
            Edificio ed=casellaCorrente.getEdificio();
            if(ed==null ||ed.getStatistica().getVita()==0){
                ArrayList<Eroe> eroi=casellaCorrente.getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
                if(eroi!=null && eroi.size()>0){
                    Casella casella=this.spostamentoEroi(clash.getGiocatoreD().getVillaggio(), casellaCorrente);

                    for(int j=0;j<eroi.size();j++){
                        Eroe e=eroi.get(j);//recupero l'eroe
                        e.setC(casella);
                        casella.AddEroe(e);//lo aggiungo alla nuova casella        
                    }
                casellaCorrente.setListaEroiA(new ArrayList<Eroe>());
                }
            }
        }
    }

    //metodo utilizzato per spostare gli eroi verso la prossima casella da attaccare
    public Casella spostamentoEroi(Villaggio v,Casella c){
        int riga=c.getPosizioneRiga();
        int colonna=c.getPosizioneColonna();
       // System.out.println("Hellooooooo:Riga: "+riga+" j: "+colonna+" ");
        int cont=0;
        int cont2=0;
        for(int i=riga-1 ;cont<3 && i>=1 && i<=v.getAltezza();i++){ 
            for(int j=colonna-1;cont2<3 && j>=1 && j<=v.getLarghezza();j++){
               // System.out.println("Riga: "+i+" j: "+j+" ");
                Casella c2=v.getCasella(i, j);
                Casella cas=this.verificaVitaEdificio(c2);
                if(cas!=null){
                    return c2;
                }
                cont2++;
            }
            cont2=0;
            cont++;        
        }
        if(riga==1 || colonna==1){
            cont=0;
            cont2=0;
            for(int i=riga-1 ;cont<3 && i<=v.getAltezza();i++){ 
                for(int j=colonna-1;cont2<3 && j<=v.getLarghezza();j++){
                    System.out.println("OI-Riga: "+i+" j: "+j+" ");
                    if(i>0 && j>0){
                        Casella c2=v.getCasella(i, j);
                        Casella cas=this.verificaVitaEdificio(c2);
                        if(cas!=null){
                            return c2;
                        } 
                    }
                    cont2++;
                }
                cont2=0;
                cont++;        
            }
        }       
        Casella c2=this.cercaCasellaVersoCuiSpostarsi(v, c);      
        return c2;   
    }
    
    private Casella verificaVitaEdificio(Casella casella){
        Edificio edificio=casella.getEdificio();
                        if(edificio!=null){
                            int vita=casella.getEdificio().getStatistica().getVita();
                            if(vita>0){ 
                                return casella;
                            }
                        } 
        return null;
    }
    
    //metodo per spostarsi verso la prima casella che si trova con la vita dell'edificio >0 
    private Casella cercaCasellaVersoCuiSpostarsi(Villaggio v,Casella c){ //45 righe ATTENZIONE VEDERE
        int prossimaRiga=0;
        int prossimaColonna=0;
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c2=v.getCasella(i, j);
                    int vita=c2.getEdificio().getStatistica().getVita();
                    if(vita>0){
                        if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()<c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()>c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()>c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()<c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()-1;
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()-1;
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()+1;
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()+1;
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        return v.getCasella(prossimaRiga,prossimaColonna);
                    }
            }
        }
        return null;
        }

    @Override
    public boolean controlloFineBattaglia(ClashGame clash) {
        return false;
    }
    
}
