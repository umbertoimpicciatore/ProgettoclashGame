
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
        this.cambiaStato(clash, new ControlloFineBattaglia());//cambio stato
    }

    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }
    
    
    
    
}
