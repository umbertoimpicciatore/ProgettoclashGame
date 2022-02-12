
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Attacco implements StatoAttacco{

    @Override
    public void cambiaStato(Battaglia battaglia, StatoAttacco st) {
        battaglia.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(Battaglia battaglia) {
     ArrayList<Casella> listC =  battaglia.caselleDifensore();//recupero le caselle del difensore
        for(int i=0;i<listC.size();i++){//per ogni casella mi recupero l'edificio
            Casella c=listC.get(i);
            Edificio ed=c.getEdificio();
            if(ed!=null){
                ModalitàAttacco modA=ed.getModalitaAttacco();
                if(modA!=null){
                    ArrayList<Casella> listaCaselleConEroiDaAttaccare= modA.caselleBersaglio(c);
                    for(int j=0;j<listaCaselleConEroiDaAttaccare.size();j++){
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
                    }                 
                }         
                } 
            }      
        }
        this.cambiaStato(battaglia,new ControlloFineBattaglia());
    }

    @Override
    public void attaccanoEroi(Battaglia battaglia) {
        ArrayList<Casella> listC =  battaglia.caselleDifensore(); //recupero le caselle del difensore      
        for(int i=0;i<listC.size();i++){   
            Casella c=listC.get(i);
            ArrayList<Eroe> eroi=c.getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
            for(int j=0;j<eroi.size();j++){
                Eroe e=eroi.get(j);//recupero l'eroe
                ArrayList<Casella> listCaselleDaAttaccare=e.getModalitaAttacco().caselleBersaglio(c);//recupero le caselle da attaccare  
                for(int k=0;k<listCaselleDaAttaccare.size();k++){ 
                    Edificio edificio=listCaselleDaAttaccare.get(k).getEdificio();
                    if(edificio!=null){
                        int vita=edificio.getStatistica().getVita();
                        int difesa=edificio.getStatistica().getDifesa();//+ la difesa della skin?
                        int attaccoEroe=e.getStat().getAttacco()+e.getSkin().getAttacco();
                        if(attaccoEroe-difesa>5 &&vita>0){
                            int attdif=attaccoEroe-difesa; 
                            vita-=attdif;                           
                        }
                        else{
                            vita-=5;
                        }
                        if(vita<0){
                            vita=0;
                        }
                        edificio.setVita(vita);
                    } 
                }
            }     
        }
       this.cambiaStato(battaglia, new ControlloFineBattaglia());
    }
    
    @Override
    public void spostaEroi(Battaglia battaglia) {
        ArrayList<Casella> listC =  battaglia.caselleDifensore(); //recupero le caselle del difensore
        for(int i=0;i<listC.size();i++){
            Casella casellaCorrente=listC.get(i);
            Edificio ed=casellaCorrente.getEdificio();
            if(ed==null ||ed.getStatistica().getVita()==0){
                ArrayList<Eroe> eroi=casellaCorrente.getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
                if(eroi!=null && eroi.size()>0){
                    Casella casella=this.spostamentoEroi(battaglia.getGiocatoreD().getVillaggio(), casellaCorrente);
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
    private Casella spostamentoEroi(Villaggio v,Casella c){
        int riga=c.getPosizioneRiga();
        int colonna=c.getPosizioneColonna();
       // System.out.println("Hellooooooo:Riga: "+riga+" j: "+colonna+" ");
        int cont=0;
        int cont2=0;
        for(int i=riga-1 ;cont<3 && i>=1 && i<=v.getAltezza();i++){ 
            for(int j=colonna-1;cont2<3 && j>=1 && j<=v.getLarghezza();j++){
               // System.out.println("Riga: "+i+" j: "+j+" ");
                Casella c2=v.getCasella(i, j);
                Casella cas=c2.verificaVitaEdificio(c2);//ATTENZIONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
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
                    //System.out.println("OI-Riga: "+i+" j: "+j+" ");
                    if(i>0 && j>0){
                        Casella c2=v.getCasella(i, j);
                        Casella cas=c2.verificaVitaEdificio(c2);//ATTENZIONEEEEEEEEEEEEEEEE
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
        System.out.println("PANICOOOOOOOOOOOO");
        Casella c2=this.cercaCasellaVersoCuiSpostarsi(v, c);      
        System.out.println("c2Riga:"+c2.getPosizioneRiga()+"c2Colonna:"+c2.getPosizioneColonna());
        return c2;   
    }
    
    
    //metodo per spostarsi verso la prima casella che si trova con la vita dell'edificio >0 
    private Casella cercaCasellaVersoCuiSpostarsi(Villaggio v,Casella c){ //45 righe ATTENZIONE VEDERE
        int prossimaRiga=0;
        int prossimaColonna=0;
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                System.out.println("i: "+i+" j: "+j);
                Casella c2=v.getCasella(i, j);
                //c2=c2.verificaVitaEdificio(c2);
                //if(c2!=null){
                
                //}
                Edificio e=c2.getEdificio();
                if(e!=null){
                    int vita=e.getStatistica().getVita();
                        if(vita>0){
                            if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()<c.getPosizioneColonna()){
                                prossimaRiga=c.getPosizioneRiga();
                                prossimaColonna=c.getPosizioneColonna()-1;
                                System.out.println("OI1");
                            }
                            else if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()>c.getPosizioneColonna()){
                                prossimaRiga=c.getPosizioneRiga();
                                prossimaColonna=c.getPosizioneColonna()+1;
                                System.out.println("OI2");
                            }
                            else if(c2.getPosizioneRiga()>c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                                prossimaRiga=c.getPosizioneRiga()+1;
                                prossimaColonna=c.getPosizioneColonna();
                                System.out.println("OI3");
                            }
                            else if(c2.getPosizioneRiga()<c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                                prossimaRiga=c.getPosizioneRiga();
                                prossimaColonna=c.getPosizioneColonna()-1;
                                System.out.println("OI4");
                            }
                            else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                                prossimaRiga=c.getPosizioneRiga()-1;
                                prossimaColonna=c.getPosizioneColonna()-1;
                                System.out.println("OI5");
                            }
                            else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                                prossimaRiga=c.getPosizioneRiga()-1;
                                prossimaColonna=c.getPosizioneColonna()+1;
                                System.out.println("OI6");
                            }
                            else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                                prossimaRiga=c.getPosizioneRiga()+1;
                                prossimaColonna=c.getPosizioneColonna()-1;
                                System.out.println("OI7");
                            }
                            else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                                prossimaRiga=c.getPosizioneRiga()+1;
                                prossimaColonna=c.getPosizioneColonna()+1;
                                System.out.println("OI8");
                            }
                            System.out.println("riga: "+prossimaRiga+" prossima colonna: "+prossimaColonna);
                            return v.getCasella(prossimaRiga,prossimaColonna);
                        }
                }        
            }
        }
        System.out.println("OIIIIIIIIII");
        return null;
        }

    @Override
    public boolean controlloFineBattaglia(Battaglia battaglia) {
        return false;
    }
    
}
