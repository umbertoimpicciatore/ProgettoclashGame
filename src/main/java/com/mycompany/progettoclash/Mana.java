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
public class Mana implements Risorsa, Cloneable {
    private String nome="Mana";
    private double quantita;
    
    public Mana(double a){
        this.quantita=a;
    
    }
    public Mana(){
        this.quantita=0;
    
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getQuantita() {
        return this.quantita;
    }

    @Override
    public void setQuantita(double a) {
        this.quantita=a;
    }
    
    public String toString(){
        String s;
        String s1="Quantità: "+ this.quantita;
        s="Risorsa:".concat(this.nome).concat(s1);
        return s;
    }
}
