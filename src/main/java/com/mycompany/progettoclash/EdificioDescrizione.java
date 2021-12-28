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
public class EdificioDescrizione {
    
    private String nome;
    private int quantitaMassima;
    private int quantitaDisponibile;
    private Risorsa prezzoDiAcquisto;
    private Risorsa prezzoDiPotenziamento;
    private int vitaMassima;
    private EdificioDescrizione edificioDescrizione;

    public EdificioDescrizione getEdificioDescrizione() {
        return edificioDescrizione;
    }

    public void setEdificioDescrizione(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public int getVitaMassima() {
        return vitaMassima;
    }

    public void setVitaMassima(int vitaMassima) {
        this.vitaMassima = vitaMassima;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantitaMassima() {
        return quantitaMassima;
    }

    public void setQuantitaMassima(int quantitaMassima) {
        this.quantitaMassima = quantitaMassima;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public Risorsa getPrezzoDiAcquisto() {
        return prezzoDiAcquisto;
    }

    public void setPrezzoDiAcquisto(Risorsa prezzoDiAcquisto) {
        this.prezzoDiAcquisto = prezzoDiAcquisto;
    }

    public Risorsa getPrezzoDiPotenziamento() {
        return prezzoDiPotenziamento;
    }

    public void setPrezzoDiPotenziamento(Risorsa prezzoDiPotenziamento) {
        this.prezzoDiPotenziamento = prezzoDiPotenziamento;
    }
    
    
}
