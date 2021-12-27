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
    protected ModalitàAttacco modA;
    private Casella c;
    public Statistica stat;
    protected Skin skin;

    public Statistica getStat() {
        return stat;
    }

    public void setStat(Statistica stat) {
        this.stat = stat;
    }

    

    protected Eroe(ModalitàAttacco modA){
      this.modA = modA;
     // this.id=id;
    }
    
    public Casella getC() {
        return c;
    }

    public void setC(Casella c) {
        this.c = c;
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
