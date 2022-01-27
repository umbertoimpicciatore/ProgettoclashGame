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
public class Municipio extends Edificio {
    
    public Municipio(RuoloEdificio re,ModalitàAttacco ma){
        super(re,ma);
    
    }

    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
}
