
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class EdificioDescrizione {
    
    private ArrayList<Edificio> edifici;
    private int idDescrizione;
    private String nome;
    private int quantitaMassima;
    private int quantiaMassimaImm;
    private Risorsa prezzoDiAcquisto;
    private int vitaMassima;
    private ModalitàAttacco modalitaAttacco;
    private Statistica statistica;

    public ModalitàAttacco getModalitaAttacco() {
        return modalitaAttacco;
    }

    public void setModalitaAttacco(ModalitàAttacco modalitaAttacco) {
        this.modalitaAttacco = modalitaAttacco;
    }

    public EdificioDescrizione(ArrayList<Edificio> edifici, int idDescrizione, String nome, int quantitaMassima, Risorsa prezzoDiAcquisto, int vitaMassima, Statistica statistica,ModalitàAttacco modalitaAttacco,int quantitaImm) {
        this.edifici = edifici;
        this.idDescrizione = idDescrizione;
        this.nome = nome;
        this.quantitaMassima = quantitaMassima;
        this.prezzoDiAcquisto = prezzoDiAcquisto;
        this.vitaMassima = vitaMassima;
        this.statistica = statistica;
        this.modalitaAttacco=modalitaAttacco;
        this.quantiaMassimaImm=quantitaImm;
    }

    public int getQuantiaMassimaImm() {
        return quantiaMassimaImm;
    }

    public void setQuantiaMassimaImm(int quantiaMassimaImm) {
        this.quantiaMassimaImm = quantiaMassimaImm;
    }
    public Statistica getStatistica() {
        return statistica;
    }

    public void setStatistica(Statistica statistica) {
        this.statistica = statistica;
    }

    public ArrayList<Edificio> getEdifici() {
        return edifici;
    }

    public void setEdifici(ArrayList<Edificio> edifici) {
        this.edifici = edifici;
    }

    public int getIdDescrizione() {
        return idDescrizione;
    }

    public void setIdDescrizione(int idDescrizione) {
        this.idDescrizione = idDescrizione;
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

    public Risorsa getPrezzoDiAcquisto() {
        return prezzoDiAcquisto;
    }

    public void setPrezzoDiAcquisto(Risorsa prezzoDiAcquisto) {
        this.prezzoDiAcquisto = prezzoDiAcquisto;
    }
    
    public void setVita(int vita){
        this.statistica.setVita(vita);
    }
    
    public String toString(){
        String s="";
        s="IDEDIFICIO:"+this.idDescrizione+" Nome: ".concat(nome)+" QuantitaMassima: "+this.quantitaMassima+" Prezzo di Acquisto: ".concat(this.prezzoDiAcquisto.toString());
        return s;
    }
    
}
