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
public interface Risorsa {
    
    public String getNome();
    public double getQuantita();
    public void setQuantita(double a);
    @Override
    public String toString();
    
}
