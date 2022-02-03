
package com.mycompany.progettoclash;

/**
 *
 * @author User
 */
public class CreaEroeFactory { 
    private static CreaEroeFactory instance = null; 
    private CreaEroeFactory() {} 
 
    public static CreaEroeFactory getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new CreaEroeFactory();
        }
        return instance;
    }
    
    public CreaEroeStrategy getStrategy() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       String className= FileDiConfigurazione.creaEroe;
       Class cls = Class.forName(className);
       CreaEroeStrategy clsInstance = (CreaEroeStrategy) cls.newInstance();
       return clsInstance;
    }
}
    

