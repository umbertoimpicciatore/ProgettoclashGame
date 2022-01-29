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
    
    public MatchMakingStrategy getStrategy()  {
       String className= FileDiConfigurazione.matchMaking;
       System.out.print(className);
//       Class cls = Class.forName(className);
       //Param1Type param1;
        //Param2Type param2;
        
        
        
      /*  
        Class cl = Class.forName(className);
        Constructor con = cl.getConstructor();
        MatchMakingStrategy xyz =(MatchMakingStrategy) con.newInstance();*/
        
        
      
        return new MatchMakingBasedOnLvGiocatoreStrategy();
      
     /* Class myClass = Class.forName(className);

        
      Class[] types = {Double.TYPE, this.getClass()};
      Constructor constructor = myClass.getConstructor(types);

      Object[] parameters = {new Double(0), this};
        Object instanceOfMyClass = constructor.newInstance(parameters);
       return matchStrategy;*/
//matchStrategy.getAvversario(g);
        /*FileReader filein= new FileReader("file_conf.txt");
        int s=filein.read();
        if (s==0){return new MatchMakingBasedOnLvEroiStrategy();}
                else{ return new MatchMakingBasedOnLvGiocatoreStrategy();
        
        
       
    }
    
//    public MatchMakingBasedOnLvGiocatoreStrategy getGiocatoreStrategy(){
//        //da implementare
//        return new MatchMakingBasedOnLvGiocatoreStrategy();
//        
//    }

    }*/
}
}
