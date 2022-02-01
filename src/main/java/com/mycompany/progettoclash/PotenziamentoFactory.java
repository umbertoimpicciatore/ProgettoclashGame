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
public class PotenziamentoFactory { 
     private static PotenziamentoFactory instance = null; 
    private PotenziamentoFactory() {} 
 
    public static PotenziamentoFactory getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new PotenziamentoFactory();
        }
        return instance;
    }
    
    public PotenziamentoStrategy getStrategy() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       String className= FileDiConfigurazione.potenziamentoEroe;
       Class cls = Class.forName(className);
       PotenziamentoStrategy clsInstance = (PotenziamentoStrategy) cls.newInstance();
       return clsInstance;
    }
}
    

