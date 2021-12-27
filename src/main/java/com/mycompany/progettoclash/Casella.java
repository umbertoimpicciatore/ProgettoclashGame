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
public class Casella {
    
    private int posizioneRiga;
    private int posizioneColonna;
    private Edificio edificio;
    private ArrayList<Eroe> listaEroiA = new ArrayList<Eroe>();
    
    /*public Casella(int colonna,int riga){
        this.posizioneColonna=colonna;
        this.posizioneRiga=riga;
    }*/

    public ArrayList<Eroe> getListaEroiA() {
        return listaEroiA;
    }

    public void setListaEroiA(ArrayList<Eroe> listaEroiA) {
        this.listaEroiA = listaEroiA;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
    
    public int getPosizioneRiga() {
        return posizioneRiga;
    }

    public void setPosizioneRiga(int posizioneRiga) {
        this.posizioneRiga = posizioneRiga;
    }

    public int getPosizioneColonna() {
        return posizioneColonna;
    }

    public void setPosizioneColonna(int posizioneColonna) {
        this.posizioneColonna = posizioneColonna;
    }
    
    
    
}
