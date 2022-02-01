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
public class PotenziamentoBasatoSuSkinStrategy implements PotenziamentoStrategy{

    @Override
    public ArrayList<Eroe> potenziaEroe(EroeDescrizione desc, Giocatore giocatore) {
        
        //To change body of generated methods, choose Tools | Templates.
        String eroeDaPotenziare=desc.getNome();        //NOME eroe selezionato da potenziare
        ArrayList<Eroe> eroiGiocatore=giocatore.getEroi();
        for (int i=0;i<eroiGiocatore.size();i++){
              Eroe eroe=eroiGiocatore.get(i);
              String s=eroe.getEroeDescrizione().getNome();
              if (s.equals(eroeDaPotenziare)){
               int attaccoInizialeSkin=eroe.getSkin().getAttacco();
               int difesaInizialeSkin=eroe.getSkin().getDifesa();
               eroe.getSkin().setAttacco(attaccoInizialeSkin+5);
               eroe.getSkin().setDifesa(difesaInizialeSkin+5);
               
              }
              
        }
        return eroiGiocatore;
    }
    
}
