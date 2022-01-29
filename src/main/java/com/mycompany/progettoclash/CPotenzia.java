
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewPotenzia;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class CPotenzia {
    
    
    //selezioni edificio, in questo caso accademiaa
    //selezionata l'accademia ti mostra gli eroi del giocatore e lui deve selezionare quello che vuole potenziare
    //poi potenzi andando ad aumentare livello eroe,punti lv giocatore e togliendo quelle risorse specifiche al giocatore
    /*public Casella selezionaEdificio(int riga,int col,Giocatore g){
       // Casella c=new Casella();
        Casella c= g.getVillaggio().getCasella(riga, col);
        c.getEdificio().getRuoloE().operazione();
        
        
        
        
    }*/
    public void operazione(Giocatore g){
       g.getAccademia();
       ViewPotenzia view=new ViewPotenzia();
       view.mostraEroi();
    }
    
    
}
