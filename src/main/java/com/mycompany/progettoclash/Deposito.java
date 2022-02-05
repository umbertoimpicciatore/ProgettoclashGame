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
    
}

