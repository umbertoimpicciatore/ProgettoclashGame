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
    private Villaggio villaggio;

    public void setVillaggio(Villaggio villaggio) {//SERVE VERAMENTE?? BASTA METTERLO NEL COSTRUTTORE
        this.villaggio = villaggio;
    }

    public Villaggio getVillaggio() {
        return villaggio;
    }
    
    
    
    public Casella(int riga,int colonna){
        this.posizioneColonna=colonna;
        this.posizioneRiga=riga;
    }
    
    public void AddEroe(Eroe e){
        this.listaEroiA.add(e);
    
    }

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
