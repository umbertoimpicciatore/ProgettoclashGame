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
    public boolean controlloFineBattaglia(ClashGame clash);
    public void attaccanoEdifici(ClashGame clash);
    public void attaccanoEroi(ClashGame clash); 
    public void cambiaStato(ClashGame clash,StatoAttacco st);
     
}
