package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class Accademia extends Edificio {

    
    
    public void potenzia(int idEroeDescrizione,Giocatore giocatore){
        EroeCatalogo edC=new EroeCatalogo();
        EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        //EroeDescrizione desc=null;
        /*for (EroeDescrizione name: giocatore.getLivelloEroi().keySet()) {//controllare bene questo
             if(name.getIdDesc()==idEroeDescrizione){
                 desc=name;
             }
        }*/
        int livello=giocatore.getLivelloEroi().get(desc);
        CreaEroeStrategy potS= CreaEroeFactory.getInstance().getStrategy();      
        //int livello=giocatore.getLivelloEroi().get(desc)+1;
        giocatore.getLivelloEroi().put(desc, livello+1);
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
