/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AttaccaTorre implements ModalitàAttacco {
    int altezza=4;
    int lunghezza=4;
     @Override
    public ArrayList<Casella> attacco(Eroe e){                
        return new ArrayList<Casella>();
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
          ArrayList<Casella> g=new ArrayList<Casella>();
        Villaggio villaggio D=e.getC().getVillaggio();
        
        i
    }
    
    
}
