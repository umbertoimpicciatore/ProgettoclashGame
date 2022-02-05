/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class NonAttacca implements ModalitàAttacco {
  

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return new ArrayList<Casella>();
    }

    @Override
    public ArrayList<Casella> attacco(Eroe e) {
        return new ArrayList<Casella>();
    }

    @Override
    public ArrayList<Casella> caselleBersaglio(Casella c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
