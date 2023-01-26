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
public class SkinBase implements Skin{
    
    private int difesa=10;
    private int attacco=10;

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
