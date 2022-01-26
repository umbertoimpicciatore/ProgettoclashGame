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
public class Accampamento extends Edificio {
    
    private ArrayList<Eroe> listaEroiGiocatore = new ArrayList<Eroe>();
    
    
    public Accampamento(RuoloEdificio re, ModalitàAttacco ma) {
        super(re, ma);
    }
    
    public ArrayList<Eroe> selezionaEroe(int idEroe,int quantita){
        ArrayList<Eroe> listaEroi = new ArrayList<Eroe>();
        int cont=0;
        
        //manca il controllo se quantità è minore uguale degli eroi disponibili
        //manca che devo togliere gli eroi
        for(int i=0;i<this.listaEroiGiocatore.size() || cont<quantita;i++){
            if(this.listaEroiGiocatore.get(i).getId()==idEroe){
                cont++;
                listaEroi.add(this.listaEroiGiocatore.get(i));
            }
            
        }
        if(cont==quantita){
            return listaEroi;
        }
        else{
            return null;
        }
    //return listaEroi;
    }
    
    
    
    
}
