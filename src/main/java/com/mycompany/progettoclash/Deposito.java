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
    
    public Deposito(Risorsa r,EdificioDescrizione desc) {
        super(desc);
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
            else{
                risorsaCorrente.setQuantita(0);
            }
            this.risorsa.setQuantita(qDeposito);
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

