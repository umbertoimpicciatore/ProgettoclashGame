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
public class SkinPotenziata implements Skin {
    
    private int difesa=15;
    private int attacco=15;

     @Override
    public int getDifesa() {
        return difesa;
    }

     @Override
    public int getAttacco() {
        return attacco;
    }
    
     @Override
    public void setAttacco(int a) {
        this.attacco=a;
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDifesa(int a) {
        this.difesa=a;
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
