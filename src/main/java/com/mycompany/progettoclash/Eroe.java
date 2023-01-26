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
public  class Eroe {
    private int id;
   // private ModalitàAttacco modA;
    private Casella casella;
    private Statistica stat;
    private Skin skin;
    private EroeDescrizione eroeDescrizione;


    public ModalitàAttacco getModalitaAttacco() {
        return eroeDescrizione.getModalitaAttacco();
    }
    
    public void setVita(int vita){
        this.stat.setVita(vita);
    
    }

 /*   public void setModA(ModalitàAttacco modA) {
        this.modA = modA;
    }*/

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public EroeDescrizione getEroeDescrizione() {
        return eroeDescrizione;
    }

    public void setEroeDescrizione(EroeDescrizione eroeDescrizione) {
        this.eroeDescrizione = eroeDescrizione;
    }
    
    

    public Statistica getStat() {
        return stat;
    }

    public void setStat(Statistica stat) {
        this.stat = stat;
    }

    

    protected Eroe(){
      
     // this.id=id;
    }
    
    public Eroe(Statistica s,Skin skin,EroeDescrizione desc,int id){
        this.eroeDescrizione=desc;
        this.id=id;
        this.skin=skin;
        this.stat=s;
    }
    
    public Casella getC() {
        return casella;
    }

    public void setC(Casella c) {
        this.casella = c;
    }
    
    public  int getId(){
        return this.id;
    }
        
 

    public void setId(int id){
        this.id = id;
    }
       
    @Override
   public String toString(){
   return "Eroe:"
           + "Statistiche: Attacco: "+stat.getAttacco()+" Difesa: "+stat.getDifesa()+" Vita: "+stat.getVita()+""
           + " SKIN: ATTACCO"+skin.getAttacco()+" Difesa: "+skin.getDifesa();
   }
    //public abstract void attacca();
}
