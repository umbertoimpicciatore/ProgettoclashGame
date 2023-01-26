
package com.mycompany.progettoclash;

import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    public MatchMakingStrategy getStrategy() {
        try {
            String className= FileDiConfigurazione.matchMaking;
            Class cls = Class.forName(className);
            MatchMakingStrategy clsInstance = (MatchMakingStrategy) cls.newInstance();
            return clsInstance;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            return null;
        }
    }
}
