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
        //int livello=giocatore.getLivelloEroi().get(desc);
        PotenziamentoStrategy potS=null;
        try {
            potS = PotenziamentoFactory.getInstance().getStrategy();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Accademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int livello=giocatore.getLivelloEroi().get(desc)+1;
        giocatore.getLivelloEroi().put(desc, livello);
        if(giocatore.getEroi()!=null){
            potS.potenziaEroe(desc, giocatore);
            //ti salvi gli eroi con con descrizione desc e la loro quantità
            //li togli dallla listaEroi del giocatore
            //li rimetti al giocatore potenziati con la factory del acquista
        }
        
    
    }
    
    public Accademia( ModalitàAttacco ma) {
        super( ma);
    }
    
    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    
}
