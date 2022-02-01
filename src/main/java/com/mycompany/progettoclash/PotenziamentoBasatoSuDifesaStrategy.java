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
public class PotenziamentoBasatoSuDifesaStrategy implements PotenziamentoStrategy  {
    
  @Override
    public ArrayList<Eroe> potenziaEroe(EroeDescrizione desc, Giocatore giocatore) {
         String eroeDaPotenziare=desc.getNome();        //NOME eroe selezionato da potenziare
        ArrayList<Eroe> eroiGiocatore=giocatore.getEroi();
        for (int i=0;i<eroiGiocatore.size();i++){
              Eroe eroe=eroiGiocatore.get(i);
              String s=eroe.getEroeDescrizione().getNome();
              if (s.equals(eroeDaPotenziare)){
                  int difesaInizialeEroe=eroe.getStat().getDifesa();
                  eroe.getStat().setAttacco(difesaInizialeEroe+5);
                  eroe.setLivello(eroe.getLivello()+1);
                  
                  
              }         
         //To change body of generated methods, choose Tools | Templates.
    }
    
    return eroiGiocatore;
    
    
    }