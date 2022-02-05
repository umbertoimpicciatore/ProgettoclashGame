
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
        //il CATALOGO è UNA VARIABILE DI CPOTENZIA? PAG382
       //g.getAccademia();
       //il giocatore in questo caso a che mi serve?????
       
       
       
       //EroeCatalogo edC=new EroeCatalogo();
       return this.giocatore.getLivelloEroi();
       //HashMap<EroeDescrizione,Integer> 
     /*  ArrayList<EroeDescrizione> desc=edC.getAllDescrizioni();
       ArrayList<Integer> livelli=new ArrayList<Integer>();
       HashMap<EroeDescrizione,Integer> eroeDesc=new HashMap<EroeDescrizione,Integer>(); 
       for (int i=0;i<desc.size();i++){
           EroeDescrizione eroeD=desc.get(i);
           int livello=this.giocatore.getLivelloEroi().get(desc);
           livelli.add(livello);
       }
     */  
      // view.mostraEroi(eroeDesc,false,false,this.giocatore);
    }
    
    public Risorsa potenzia(int idEroeDescrizione){
        EroeCatalogo catalogo=new EroeCatalogo();
        EroeDescrizione desc=catalogo.getEroeDescrizione(idEroeDescrizione);
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
    
    public void conferma(boolean conferma,int idEroeDescrizione){
        //manca controllo su conferma
        Accademia acc=this.giocatore.getAccademia();
        acc.potenzia(idEroeDescrizione,this.giocatore);
    }
    
    
}
