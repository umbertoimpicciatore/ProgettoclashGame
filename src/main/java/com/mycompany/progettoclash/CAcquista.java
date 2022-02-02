package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewAcquista;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CAcquista {
    
    private Giocatore giocatore;
    
    public CAcquista(Giocatore g) {
        this.giocatore=g;
    }
    
    public void operazione(Giocatore giocatore){
        ViewAcquista view=new ViewAcquista();
        
        HashMap<EroeDescrizione,Integer> eroeDesc=this.giocatore.getLivelloEroi();
        view.mostraEroi(eroeDesc,false,giocatore);
    }
    
    public void acquistaEroi(int idEroeDescrizione,int quantita){
        Accampamento acc=this.giocatore.getAccampamento();
        acc.acquistaEroi(idEroeDescrizione,quantita,this.giocatore);
        
    }
}
