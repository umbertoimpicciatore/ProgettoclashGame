package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Accademia extends Edificio {

    public Accademia(EdificioDescrizione desc){
        super(desc);
    }
    public Accademia(){
        
    }
    
    public void potenzia(Giocatore giocatore){
        AcquistoEroiEdificio d=giocatore.getAccampamento().getAcquisto();
        EroeDescrizione desc=d.getEroeDescrizione();
        giocatore.aumentaLivelloEroe(desc);       
        CreaEroeStrategy potS= CreaEroeFactory.getInstance().getStrategy();   
        Accampamento acc=giocatore.getAccampamento();
        int quantita=giocatore.getAccampamento().removeEroe(desc, giocatore);
        d.setQuantita(quantita);
        acc.setAcquisto(d);
        if(giocatore.getEroi()!=null){
            potS.creaEroe(acc);
        }
        Risorsa prezzoPot=desc.getPrezzoDiPotenziamento();
        giocatore.rimuoviRisorse(prezzoPot);    
    }

    
    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    
}
