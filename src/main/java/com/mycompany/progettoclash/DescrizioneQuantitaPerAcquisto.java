
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class DescrizioneQuantitaPerAcquisto {

    private EdificioDescrizione edificioDescrizione;
    private EroeDescrizione eroeDescrizione;
    private int quantita;
    
    public DescrizioneQuantitaPerAcquisto() {
    }

    public DescrizioneQuantitaPerAcquisto(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public DescrizioneQuantitaPerAcquisto(EroeDescrizione eroeDescrizione, int quantita) {
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
