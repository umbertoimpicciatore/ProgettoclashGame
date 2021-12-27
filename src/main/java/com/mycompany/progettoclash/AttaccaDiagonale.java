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
public class AttaccaDiagonale implements ModalitàAttacco{
    int altezza=4;//mettere gli attributi di villaggio
    int lunghezza=4;

    @Override
    public ArrayList<Casella> attacco(Eroe e) {
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        int col=e.getC().getPosizioneColonna();
        int riga=e.getC().getPosizioneRiga();
        int cont=col;
        for(int i=riga;i>1  && cont<=altezza && cont>1;i--){
           // System.out.println("ciao");
            Casella c=new Casella();
            c.setPosizioneColonna(cont-1);
            c.setPosizioneRiga(i-1);
            cont--;
            g.add(c);
        }
        cont=col;
        for(int i=riga;i<altezza && cont<lunghezza;i++){
            Casella c=new Casella();
            c.setPosizioneColonna(cont+1);
            c.setPosizioneRiga(i+1);
            cont++;
            g.add(c);
        }
        //for per DEBUG
        for(int j=0;j<g.size();j++){
            
            System.out.println("Riga: "+g.get(j).getPosizioneRiga());
            System.out.println("Colonna: "+g.get(j).getPosizioneColonna());
            System.out.println();
        }
        
        return g;
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }
    
}
