/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
