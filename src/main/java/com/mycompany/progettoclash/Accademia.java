package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Accademia extends Edificio {

    
    
    public void potenzia(int idEroeDescrizione,Giocatore giocatore){
        EroeCatalogo edC=new EroeCatalogo();
        EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        giocatore.aumentaLivelloEroe(desc);
        //int livello=giocatore.getLivelloEroi().get(desc);
        CreaEroeStrategy potS= CreaEroeFactory.getInstance().getStrategy();      
        //giocatore.getLivelloEroi().put(desc, livello+1);
        int quantita=giocatore.getAccampamento().removeEroe(idEroeDescrizione, giocatore);
        if(giocatore.getEroi()!=null){
            potS.creaEroe(desc,quantita, giocatore);
        }
        Risorsa prezzoPot=desc.getPrezzoDiPotenziamento();
        giocatore.rimuoviRisorse(prezzoPot);    
    }

    
    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    
}
