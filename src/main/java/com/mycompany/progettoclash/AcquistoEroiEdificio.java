
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class AcquistoEroiEdificio {

    private EdificioDescrizione edificioDescrizione;
    private EroeDescrizione eroeDescrizione;
    private int quantita;
    private int riga;
    private int colonna;

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }
    
    public AcquistoEroiEdificio() {
    }

    public AcquistoEroiEdificio(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public AcquistoEroiEdificio(EroeDescrizione eroeDescrizione, int quantita) {
        this.eroeDescrizione = eroeDescrizione;
        this.quantita = quantita;
    }


    public EdificioDescrizione getEdificioDescrizione() {
        return edificioDescrizione;
    }

    public void setEdificioDescrizione(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public EroeDescrizione getEroeDescrizione() {
        return eroeDescrizione;
    }

    public void setEroeDescrizione(EroeDescrizione eroeDescrizione) {
        this.eroeDescrizione = eroeDescrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    
    
}
