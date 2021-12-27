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
public class AttaccaDuePosizioni implements ModalitàAttacco{
    @Override
    public ArrayList<Casella> attacco(Eroe e){
        
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        int col=e.getC().getPosizioneColonna();
        int r=e.getC().getPosizioneRiga();
        Casella c2=new Casella();
        c2.setPosizioneColonna(col+1);
        c2.setPosizioneRiga(r+1);
        g.add(c2);
        return g;
        //System.out.println("attacca Due Posizioni");
        //System.out.println(e.getC().getPosizioneRiga());
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }
    
}
