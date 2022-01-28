/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.io.FileReader;
import java.io.IOException;

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
    
    public MatchMakingStrategy getEroeStrategy() throws IOException{
        FileReader filein= new FileReader("file_conf.txt");
        int s=filein.read();
        if (s==0){return new MatchMakingBasedOnLvEroiStrategy();}
                else{ return new MatchMakingBasedOnLvGiocatoreStrategy();
        
        
    }
    
//    public MatchMakingBasedOnLvGiocatoreStrategy getGiocatoreStrategy(){
//        //da implementare
//        return new MatchMakingBasedOnLvGiocatoreStrategy();
//        
//    }

    }}
