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
public interface ModalitàAttacco {
    final int altezza=new Villaggio().getAltezza();
    final int lunghezza=new Villaggio().getLarghezza();
    public ArrayList<Casella> attacco(Eroe e);
    public ArrayList<Casella> attaccoEdificio(Edificio e);
    public ArrayList<Casella> caselleBersaglio(Casella c);
    
}
