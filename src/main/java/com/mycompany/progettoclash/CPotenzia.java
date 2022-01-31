
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewPotenzia;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class CPotenzia {
    
    private Giocatore g;

    public CPotenzia(Giocatore g) {
        this.g = g;
    }
    
    //selezioni edificio, in questo caso accademiaa
    //selezionata l'accademia ti mostra gli eroi del giocatore e lui deve selezionare quello che vuole potenziare
    //poi potenzi andando ad aumentare livello eroe,punti lv giocatore e togliendo quelle risorse specifiche al giocatore
    /*public Casella selezionaEdificio(int riga,int col,Giocatore g){
       // Casella c=new Casella();
        Casella c= g.getVillaggio().getCasella(riga, col);
        c.getEdificio().getRuoloE().operazione();
        
        
        
        
    }*/
    public void operazione(){
        //il CATALOGO è UNA VARIABILE DI CPOTENZIA? PAG382
       //g.getAccademia();
       //il giocatore in questo caso a che mi serve?????
       ViewPotenzia view=new ViewPotenzia();
       EroeCatalogo edC=new EroeCatalogo();
       ArrayList<EroeDescrizione> desc=edC.getAllDescrizioni();
       view.mostraEroi(desc,false);
    }
    
    public void potenzia(int idEroeDescrizione){
        //qui serve il giocatore per andare a modificare solo gli eroi di quel giocatore?
        //richiamo accademia che si occupero di fare tutto ciò che segue?
        
        EroeCatalogo edC=new EroeCatalogo();
        
        EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        ArrayList<Eroe> eroi=desc.getEroi();
        for(int i=0;i<eroi.size();i++){
            Statistica s=eroi.get(i).getStat();
            //modifico statistiche secondo delle regole
            //modifico livello per ciascun eroe
            //modifico livello giocatore
        
        }
        //richiamo view
    }
    
    
}
