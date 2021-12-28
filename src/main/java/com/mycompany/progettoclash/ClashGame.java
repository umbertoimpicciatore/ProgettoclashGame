
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ClashGame {
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    
    public ArrayList<Casella> caselleDifensore(){
        
        return giocatoreD.getVillaggio().getCaselle();
    }
    
    /*
    public void attaccaEroe(){
        //Villaggio v=giocatoreD.getVillaggio();
        //v.getCaselle();
        //this.caselleDifensore();
        for(int i=0;i< this.caselleDifensore().size();i++){
            Casella c= this.caselleDifensore().get(i);
            ArrayList<Eroe> listE = c.getListaEroiA();
                    if(listE!=null){
                        for(int j=0;j<listE.size();j++){
                            Eroe e=listE.get(j);
                            //e.attacca();
                        }
            }
        }
    }*/
    
}
