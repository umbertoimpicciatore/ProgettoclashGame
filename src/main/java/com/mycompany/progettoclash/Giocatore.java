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
public class Giocatore {
    private String nome;
    private Villaggio villaggio;

    public Villaggio getVillaggio() {
        return villaggio;
    }

    public void setVillaggio(Villaggio v) {
        this.villaggio = v;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
