package com.mycompany.progettoclash;


/**
 *
 * @author Lorenzo
 */
public class TrovaAvversario {
    
        public Giocatore getAvversario(Giocatore ga){
           MatchMakingStrategy strategy=MatchMakingFactory.getInstance().getStrategy();
           return strategy.getAvversario(ga);
        }
    
}
