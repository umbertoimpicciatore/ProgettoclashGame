/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class EroeDescrizione {
    
    private ArrayList<Eroe> eroi;//sul libro c'è solo Eroe e non arrayList
    private String nome;
    private int idDesc;
    private int quantitaMassima;
    private Risorsa prezzoDiAcquisto;
    private Risorsa prezzoDiPotenziamento;
    private int vitaMassima;
    private Statistica statisticaIniziale;
    private ModalitàAttacco modalitaAttacco;

    
    
    public EroeDescrizione() {

    }

    public EroeDescrizione(int idDesc,String nome, int quantitaMassima, Risorsa prezzoDiAcquisto, Risorsa prezzoDiPotenziamento, int vitaMassima,Statistica statistica,ModalitàAttacco m) {
        this.idDesc=idDesc;
        this.nome = nome;
        this.quantitaMassima = quantitaMassima;
        this.prezzoDiAcquisto = prezzoDiAcquisto;
        this.prezzoDiPotenziamento = prezzoDiPotenziamento;
        this.vitaMassima = vitaMassima;
        this.statisticaIniziale=statistica;
        this.modalitaAttacco=m;
    }

    public ModalitàAttacco getModalitaAttacco() {
        return modalitaAttacco;
    }

    public void setModalitaAttacco(ModalitàAttacco modalitaAttacco) {
        this.modalitaAttacco = modalitaAttacco;
    }
    
        
    public Statistica getStatisticaIniziale() {
            return statisticaIniziale;
    }

    public void setStatisticaIniziale(Statistica statisticaIniziale) {
            this.statisticaIniziale = statisticaIniziale;
    }
    
    
    public int getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(int idDesc) {
        this.idDesc = idDesc;
    }
    
    public ArrayList<Eroe> getEroi() {
        return eroi;
    }

    public void setEroi(ArrayList<Eroe> eroi) {
        this.eroi = eroi;
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

    public Risorsa getPrezzoDiPotenziamento() {
        return prezzoDiPotenziamento;
    }

    public void setPrezzoDiPotenziamento(Risorsa prezzoDiPotenziamento) {
        this.prezzoDiPotenziamento = prezzoDiPotenziamento;
    }
    
    @Override
    public String toString(){
        String s="";
        s="IDEROE:"+this.idDesc+" Nome: ".concat(nome)+" QuantitaMassima: "+this.quantitaMassima+" Prezzo di Acquisto: ".concat(this.prezzoDiAcquisto.toString()+" PrezzoPotenziamento: ".concat(this.prezzoDiPotenziamento.toString()));
        return s;
    }
    
    public String toString2(){
        String s="IDEROE:"+this.idDesc+" Nome: ".concat(nome);
        return s;
    }
    
    
}
