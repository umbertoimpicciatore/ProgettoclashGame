
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewPotenzia;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CPotenzia {
    
    private Giocatore giocatore;

    public CPotenzia(Giocatore g) {
        this.giocatore = g;
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
       
       //EroeCatalogo edC=new EroeCatalogo();
       HashMap<EroeDescrizione,Integer> eroeDesc=this.giocatore.getLivelloEroi();
     /*  ArrayList<EroeDescrizione> desc=edC.getAllDescrizioni();
       ArrayList<Integer> livelli=new ArrayList<Integer>();
       HashMap<EroeDescrizione,Integer> eroeDesc=new HashMap<EroeDescrizione,Integer>(); 
       for (int i=0;i<desc.size();i++){
           EroeDescrizione eroeD=desc.get(i);
           int livello=this.giocatore.getLivelloEroi().get(desc);
           livelli.add(livello);
       }
     */  
       view.mostraEroi(eroeDesc,false);
    }
    
    public void potenzia(int idEroeDescrizione){
        //qui serve il giocatore per andare a modificare solo gli eroi di quel giocatore?
        //richiamo accademia che si occupero di fare tutto ciò che segue?
        Accademia acc=this.giocatore.getAccademia();
        acc.potenzia(idEroeDescrizione,this.giocatore);
        
        /*EroeCatalogo edC=new EroeCatalogo();
        EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        int livello=this.giocatore.getLivelloEroi().get(desc);
        */

            //modifico statistiche secondo delle regole
            //modifico livello per ciascun eroe
            //modifico livello giocatore

        //richiamo view
    }
    
    
}
