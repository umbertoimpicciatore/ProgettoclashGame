/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class MatchMakingFactory {
    private static MatchMakingFactory instance = null; 
    private MatchMakingFactory() {} 
 
    public static MatchMakingFactory getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new MatchMakingFactory();
        }
        return instance;
    }
    
    public MatchMakingBasedOnLvEroiStrategy getEroeStrategy(){
        //da implementare
        return new MatchMakingBasedOnLvEroiStrategy();
    }
    
    public MatchMakingBasedOnLvGiocatoreStrategy getGiocatoreStrategy(){
        //da implementare
        return new MatchMakingBasedOnLvGiocatoreStrategy();
        
    }

}
