
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
    
    public MatchMakingStrategy getStrategy() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       String className= FileDiConfigurazione.matchMaking;
       Class cls = Class.forName(className);
       MatchMakingStrategy clsInstance = (MatchMakingStrategy) cls.newInstance();
       return clsInstance;
    }
}
