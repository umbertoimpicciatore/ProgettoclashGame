
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewPotenzia;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CPotenzia {
    
    private Giocatore giocatore;
    //ViewPotenzia view=new ViewPotenzia();

    public CPotenzia(Giocatore g) {
        this.giocatore = g;
    }
    

    public HashMap<EroeDescrizione,Integer>  operazione(){
       return this.giocatore.getLivelloEroi();

    }
    
    public Risorsa potenzia(int idEroeDescrizione){
        EroeCatalogo catalogo=new EroeCatalogo();
        EroeDescrizione desc=catalogo.getEroeDescrizione(idEroeDescrizione);
        AcquistoEroiEdificio d=new AcquistoEroiEdificio(desc,0); 
        this.giocatore.getAccampamento().setAcquisto(d);
        Risorsa prezzoPot=desc.getPrezzoDiPotenziamento();
        boolean b=this.giocatore.controllaRisorsa(prezzoPot);
        if(b==true){
            return prezzoPot;
        }
        else{
            return null;
        }
        
        /*
        if(b==true){
            view.conferma(idEroeDescrizione, prezzoPot,this.giocatore);
        }
        else{
            view.mostraEroi(this.giocatore.getLivelloEroi(),false,true,this.giocatore);
        }*/
    }
    
    public void conferma(){
        Accademia acc=this.giocatore.getAccademia();
        acc.potenzia(this.giocatore);
    }
    
}
