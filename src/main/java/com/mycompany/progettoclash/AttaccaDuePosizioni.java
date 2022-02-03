/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class AttaccaDuePosizioni implements ModalitàAttacco{
    
    //int altezza=4;//mettere gli attributi di villaggio
    //int lunghezza=4;
    
    public ArrayList<Casella> attacco(Eroe e){  
        Villaggio v=e.getC().getVillaggio();
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        int colonna=e.getC().getPosizioneColonna();
        int riga=e.getC().getPosizioneRiga();
        //System.out.println("Hellooooooo:Riga: "+riga+" j: "+colonna+" ");
        int cont=0;
        int cont2=0;
        for(int i=riga-1 ;cont<3 && i>=1 && i<=altezza;i++){ 
            for(int j=colonna-1;cont2<3 && j>=1 && j<=lunghezza;j++){
                //System.out.println("Riga: "+i+" j: "+j+" ");
                if( i!=riga || j!=colonna){
                Casella c2=v.getCasella(i, j);
                Casella cas=c2.verificaVitaEdificio(c2);//ATTTENZIONEEEEEEEEEEEEEEEEEEE
                if(cas!=null){
                    g.add(c2);
                    return g;
                }
                }
                
                cont2++;
            }
            cont2=0;
            cont++;        
        }
        if(riga==1 || colonna==1){
            cont=0;
            cont2=0;
            for(int i=riga-1 ;cont<3 && i<=altezza;i++){ 
                for(int j=colonna-1;cont2<3 && j<=lunghezza;j++){
                   // System.out.println("OI-Riga: "+i+" j: "+j+" ");
                    if(i>0 && j>0 && (i!=riga || j!=colonna)){
                       // System.out.println("OI-Riga: "+i+" j: "+j+" FUCKKKKK");
                        Casella c2=v.getCasella(i, j);
                        Casella cas=c2.verificaVitaEdificio(c2);//ATTTENZIONEEEEEEEEEEEEEEEEEEE
                        if(cas!=null){
                            g.add(c2);
                            return g;
                        } 
                    }
                    cont2++;
                }
                cont2=0;
                cont++;        
            }
        }       
        
        return g;

    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }
    
 /*    private Casella verificaVitaEdificio(Casella casella){
        Edificio edificio=casella.getEdificio();
                        if(edificio!=null){
                            int vita=casella.getEdificio().getStatistica().getVita();
                            if(vita>0){ 
                                return casella;
                            }
                        } 
        return null;
    }*/
    
}
