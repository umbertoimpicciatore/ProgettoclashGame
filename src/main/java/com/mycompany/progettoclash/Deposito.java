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
    private Risorsa risorsa;
    

    
    

    public Risorsa getRisorsa() {
        return risorsa;
    }

    public void setRisorsa(Risorsa risorsa) {
        this.risorsa = risorsa ;
    }
    
     public Deposito(RuoloEdificio re, ModalitàAttacco ma) {
        super(re, ma);
    }
    
}
//     public void perdiOro(ClashGame clash,OttenimentoRisorseStrategy d){                           
//     this.setOro(d.ottieniRisorsa(clash));
//     
//     
//     }

