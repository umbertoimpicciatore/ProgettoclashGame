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
public class Immagazzinare implements RuoloEdificio {

   // @Override
    public void attacca() {
         System.out.println("Non attacca");
    }

    @Override
    public void operazione() {
        System.out.println("Inserisce");
    }
    
}
