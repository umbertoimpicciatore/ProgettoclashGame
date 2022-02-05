
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public abstract class Edificio {
    private int id;
    //private ModalitàAttacco modA;
    private Statistica statistica;
    private Casella casella;
    private EdificioDescrizione edificioDescrizione;

    public EdificioDescrizione getEdificioDescrizione() {
        return edificioDescrizione;
    }

    public void setEdificioDescrizione(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public abstract void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore); //l'ho messo per l'accampamento



    public Edificio(){
    
    }
    
     public Casella getCasella() {
        return casella;
    }

    public void setCasella(Casella casella) {
        this.casella = casella;
    }
    public void setVita(int vita){
        this.statistica.setVita(vita);
    
    }
            
     public Statistica getStatistica() {
        return statistica;
    }

    public void setStatistica(Statistica statistica) {
        this.statistica = statistica;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ModalitàAttacco getModalitaAttacco(){
        return this.edificioDescrizione.getModalitaAttacco();
    }


    
}
