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
    
    public void selezionaOperazione(Giocatore giocatore){
        HashMap<EroeDescrizione,Integer> eroeDesc=this.giocatore.getLivelloEroi();
        view.mostraEroi(eroeDesc,false,false,giocatore);
    }
    
    public void acquistaEroi(int idEroeDescrizione,int quantita){
        
        EroeCatalogo catalogo=new EroeCatalogo();
        EroeDescrizione desc=catalogo.getEroeDescrizione(idEroeDescrizione);
        AcquistoEroiEdificio d=new AcquistoEroiEdificio(desc,quantita); 
        this.giocatore.getAccampamento().setAcquisto(d);
        Risorsa prezzoAcquisto=desc.getPrezzoDiAcquisto();
        double quantitaAcquisto=prezzoAcquisto.getQuantita();
        double q=quantitaAcquisto*quantita;
        prezzoAcquisto.setQuantita(q);
        boolean b=this.giocatore.controllaRisorsa(prezzoAcquisto);
        prezzoAcquisto.setQuantita(quantitaAcquisto);
        if(b==true){
            view.conferma(idEroeDescrizione, quantita, prezzoAcquisto,this.giocatore);
        }
        else{
            view.mostraEroi(this.giocatore.getLivelloEroi(),false,true, giocatore);
        }

    }
    
    public void conferma(){
        Accampamento acc=this.giocatore.getAccampamento();
        acc.acquistaEroi();

    }
}
