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
public class TrovaAvversario {
    private MatchMakingStrategy strategy;
    
    public TrovaAvversario(MatchMakingStrategy strategy) {
        this.strategy = strategy;
    }
    
    

    public MatchMakingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MatchMakingStrategy strategy) {
        this.strategy = strategy;
    }

    
    
    
        public Giocatore getAvversario(Giocatore g){
            
            return this.strategy.getAvversario(g);//da implementare
    }
    
}
