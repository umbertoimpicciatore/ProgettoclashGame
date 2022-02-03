package com.mycompany.progettoclash;


/**
 *
 * @author Lorenzo
 */
public class TrovaAvversario {
    
        public Giocatore getAvversario(Giocatore ga) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
           MatchMakingStrategy strategy=MatchMakingFactory.getInstance().getStrategy();
           return strategy.getAvversario(ga);
        }
    
}
