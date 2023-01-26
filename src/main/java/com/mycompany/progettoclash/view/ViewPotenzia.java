
package com.mycompany.progettoclash.view;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.Risorsa;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Lorenzo
 */
public class ViewPotenzia {
    
    private CPotenzia potenzia;
    
    public void selezionaOperazione(Giocatore g){
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";
        int ris=this.inserisci(s);
        potenzia=new CPotenzia(g);
        HashMap<EroeDescrizione,Integer> eroeDesc =potenzia.selezionaOperazione();
        this.mostraEroi(eroeDesc, false, false,g);
    }
    
    public void mostraEroi(HashMap<EroeDescrizione,Integer> eroeDesc,boolean errore,boolean errorePrezzo,Giocatore g){
        HashMap<String,Double> map=g.mostraRisorse();
            for (String name: map.keySet()) {
            String key = name;
            Double value = map.get(name);
            System.out.println(key + " " + value);
        }
        if(errore){
            System.out.println("IdEroe inserito non corretto");
        }
        if(errorePrezzo){
            System.out.println("Non hai a disposizione risorse sufficenti");
        }
        
        for (EroeDescrizione name: eroeDesc.keySet()) {
            String key = name.toString();
            String value = eroeDesc.get(name).toString();
            System.out.println(key + " Livello: " + value);
        }

        String s="Inserisci idEroe da potenziare oppure 0 per annullare";
        int ris=this.inserisci(s);
        if(ris==0){
            ViewIniziale view=new ViewIniziale();
            view.selezionaOperazione(g,false);
        }
        else{
            potenzia=new CPotenzia(g);
            Risorsa r=potenzia.selezionaEroe(ris);
            if(r!=null){
                this.conferma(ris, r,g);
            }
            else{
                mostraEroi(eroeDesc,false,true,g);
            }
        }       
    }
    

    
     public void conferma(int idEroeDescrizione,Risorsa r,Giocatore g){
        String s="Sei sicuro di voler potenziare l' eroe con idEroeDescrizione:" +idEroeDescrizione+"?\n Il costo di potenziamento è di: "+r.toString()+"\n Premi 1 per confermare altro per annulla";
        int ris=this.inserisci(s);
        if(ris==1){
            potenzia.confermaPotenziamento();
        }
        ViewIniziale view=new ViewIniziale();
        view.selezionaOperazione(g,false);
    }
     
    private int inserisci(String strDaVisualizzare){
        
        int var=0;
        Scanner sc=new Scanner(System.in);
        do {
             System.out.println(strDaVisualizzare);
             while (!sc.hasNextInt()) {
                 System.out.println("Errore, immetti un numero positivo");
                 sc.next(); 
             }
             var = sc.nextInt();
         } while (var < 0);
         return var;
    }
    
}
