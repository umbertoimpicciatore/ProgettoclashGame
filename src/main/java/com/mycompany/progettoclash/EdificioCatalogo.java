/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.HashMap;

/**
 *
 * @author User
 */
public class EdificioCatalogo {
    private HashMap<Edificio,EdificioDescrizione > descrizioni;
    
    public EdificioCatalogo(){
        descrizioni= new HashMap<>();
        loadEdificiDescrizioni();
    }
    
    public EdificioDescrizione getEdificioDescrizione(Edificio edificio){
        return descrizioni.get(edificio);
    }
    
    private void loadEdificiDescrizioni(){
        Edificio edificio;
        String nome;
        int quantitaMassima;
        int quantitaDisponibile;
        Risorsa prezzoDiAcquisto;
        Risorsa prezzoDiPotenziamento;
        int vitaMassima;
        
        //edificio=new Edificio(1);
        nome="Deposito";
        
    }
}