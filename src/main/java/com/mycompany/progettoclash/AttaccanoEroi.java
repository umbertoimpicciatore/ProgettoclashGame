
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class AttaccanoEroi implements StatoAttacco{

    @Override
    public void esegui(ClashGame clash) {       
        ArrayList<Casella> listC =  clash.caselleDifensore(); //recupero le caselle del difensore      
        for(int i=0;i<listC.size();i++){       
            ArrayList<Eroe> eroi=listC.get(i).getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
            for(int j=0;j<eroi.size();j++){
                Eroe e=eroi.get(j);//recupero l'eroe
                ArrayList<Casella> listCaselleDaAttaccare=e.getModA().attacco(e);//recupero le caselle da attaccare  
                //int almenoUnEdificioAttaccato=0;
                for(int k=0;k<listCaselleDaAttaccare.size();k++){
                    //MANCA CONTROLLO SULLA VITA DELL'EDIFICIO
                    Casella c=listCaselleDaAttaccare.get(k);
                    //System.out.print(c.getPosizioneColonna()+""+c.getPosizioneRiga()+" ");
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
                    //c.setListaEroiA(listE);
                   // i//nt vita1=c.getListaEroiA().get(0).getStat().getVita();
                    //clash.getGiocatoreD().getVillaggio().setCasella(c);
                   // listaCaselleConEroiDaAttaccare.set(j, c);
                    
                }
            }      
        }
        this.cambiaStato(clash,new ControlloFineBattaglia());
    }
    
    
    
    
}
