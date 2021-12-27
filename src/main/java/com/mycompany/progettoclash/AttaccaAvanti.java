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
public class AttaccaAvanti implements ModalitàAttacco {
    @Override
    public ArrayList<Casella> attacco(Eroe e){
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        return g;
        //Edificio ed=
        
        //System.out.println("attaccoAvanti");
       // System.out.println(e.getC().getPosizioneRiga());
        
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return new ArrayList<Casella>();
    }
    
}
