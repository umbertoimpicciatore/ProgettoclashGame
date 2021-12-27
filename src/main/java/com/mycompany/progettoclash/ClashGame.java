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
public class ClashGame {
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    
    public ArrayList<Casella> caselleDifensore(){
        
        return giocatoreD.getVillaggio().getCaselle();
    }
    
    
    public void attaccaEroe(){
        Villaggio v=giocatoreD.getVillaggio();
        v.getCaselle();
        for(int i=0;i<v.getCaselle().size();i++){
            Casella c=v.getCaselle().get(i);
            ArrayList<Eroe> listE = c.getListaEroiA();
                    if(listE!=null){
                        for(int j=0;j<listE.size();j++){
                            Eroe e=listE.get(j);
                            //e.attacca();
                        }
            }
        }
    }
    
}
