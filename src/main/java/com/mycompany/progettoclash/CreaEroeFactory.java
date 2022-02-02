/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
       String className= FileDiConfigurazione.potenziamentoEroe;
       Class cls = Class.forName(className);
       CreaEroeStrategy clsInstance = (CreaEroeStrategy) cls.newInstance();
       return clsInstance;
    }
}
    

