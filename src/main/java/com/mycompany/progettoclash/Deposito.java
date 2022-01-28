/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author User
 */
public class Deposito extends Edificio {
    private Oro oro;
    private Statistica s;
    private int danni;

    public int getDanni() {
        return danni;
    }

    public void setDanni(int danni) {
        this.danni = danni;
    }

    public Statistica getS() {
        return s;
    }

    public void setS(Statistica s) {
        this.s = s;
    }

    public Oro getOro() {
        return oro;
    }

    public void setOro(Oro oro) {
        this.oro = oro;
    }
    
     public Deposito(RuoloEdificio re, ModalitàAttacco ma) {
        super(re, ma);
    }
     public void aggiungiOro(int a){
       this.setOro(new Oro(this.oro.getQuantita()+a));
}
     public void perdiOro(ClashGame clash){                           
     int a=this.danni/this.s.getVita()*this.oro.getQuantita();
     this.setOro(new Oro(oro.getQuantita()-a));
     clash.getGiocatoreA().getDeposito().
     }
}
