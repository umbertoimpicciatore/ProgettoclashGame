/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public interface StatoAttacco {
    public boolean controlloFineBattaglia(Battaglia battaglia);
    public void attaccanoEdifici(Battaglia battaglia);
    public void attaccanoEroi(Battaglia battaglia); 
    public void cambiaStato(Battaglia battaglia,StatoAttacco st);
    public void spostaEroi(Battaglia battaglia);
     
}
