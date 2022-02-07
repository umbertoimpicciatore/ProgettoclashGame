package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public abstract class Deposito extends Edificio {
    private Risorsa risorsa;
    

    public Risorsa getRisorsa() {
        return risorsa;
    }

    public void setRisorsa(Risorsa risorsa) {
        this.risorsa = risorsa ;
    }
    
    public Deposito(Risorsa r) {
        this.risorsa=r;
    }

    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    public Risorsa addRisorsa(Risorsa risorsaCorrente){
        double quantita=risorsaCorrente.getQuantita();//quantita da aggiungere
        double qDeposito=this.risorsa.getQuantita();//quantita deposito
        double quantitaMassima=this.getEdificioDescrizione().getQuantiaMassimaImm();
        if(qDeposito<quantitaMassima){
            qDeposito+=quantita;
            quantita=0;
            if(qDeposito>quantitaMassima){//se vai oltre la capacita
                quantita=qDeposito-quantitaMassima;
                qDeposito-=quantita;
                risorsaCorrente.setQuantita(quantita);
            }
            this.risorsa.setQuantita(qDeposito);
            //d.setRisorsa(r);
        }
        return risorsaCorrente;
        
    }
    
    public void perdiRisorsa(double quantita){
        double q=this.risorsa.getQuantita();
        this.risorsa.setQuantita(q-quantita);
        if(this.risorsa.getQuantita()==0){
            this.risorsa.setQuantita(0);
        }
    
    }
    
}

