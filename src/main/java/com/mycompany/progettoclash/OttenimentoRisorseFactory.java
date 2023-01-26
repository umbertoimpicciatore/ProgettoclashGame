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
public class OttenimentoRisorseFactory {
    private static OttenimentoRisorseFactory instance = null; 
    private OttenimentoRisorseFactory() {} 
 
    public static OttenimentoRisorseFactory getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new OttenimentoRisorseFactory();
        }
        return instance;
    }
    
    public OttenimentoRisorseStrategy getStrategy() {
        try {
            String className= FileDiConfigurazione.ottenimentoRisorse;
            Class cls = Class.forName(className);
            OttenimentoRisorseStrategy clsInstance = (OttenimentoRisorseStrategy) cls.newInstance();
            return clsInstance;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            return null;
        }
    }
    
}
