package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewAcquista;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CAcquista {
    
    private Giocatore giocatore;
    private ViewAcquista view=new ViewAcquista();
    //private static CAcquista instance = null; 

    /*public static CAcquista getInstance(Giocatore g) {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new CAcquista(g);
        }
        return instance;
    }*/
    public  CAcquista(Giocatore g) {
        this.giocatore=g;
    }
    
    public void operazione(Giocatore giocatore){

        
        HashMap<EroeDescrizione,Integer> eroeDesc=this.giocatore.getLivelloEroi();
        view.mostraEroi(eroeDesc,false,false,giocatore);
    }
    
    public void acquistaEroi(int idEroeDescrizione,int quantita){
        EroeCatalogo catalogo=new EroeCatalogo();
        EroeDescrizione desc=catalogo.getEroeDescrizione(idEroeDescrizione);
        Risorsa prezzoAcquisto=desc.getPrezzoDiAcquisto();
        double q=prezzoAcquisto.getQuantita()*quantita;
        prezzoAcquisto.setQuantita(q);
        boolean b=this.giocatore.controllaRisorsa(prezzoAcquisto);
        if(b==true){
            view.conferma(idEroeDescrizione, quantita, prezzoAcquisto,this.giocatore);
        }
        else{
            view.mostraEroi(this.giocatore.getLivelloEroi(),false,true, giocatore);
        }

    }
    
    public void conferma(boolean conferma,int idEroeDescrizione,int quantita){
        // mettere controllo sulla conferma
        Accampamento acc=this.giocatore.getAccampamento();
        acc.acquistaEroi(idEroeDescrizione,quantita,this.giocatore);

    }
}
