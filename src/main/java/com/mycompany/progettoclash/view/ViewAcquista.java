package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.CAcquista;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.Risorsa;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewAcquista {
    
    CAcquista acquista;
    
    public void selezionaOperazione(Giocatore g){//attenzione, chi glielo passa g?
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";

        int ris=this.inserisci(s);
        switch (ris) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                acquista=new CAcquista(g);
                //CAcquista.getInstance(g).operazione(g);
                acquista.operazione(g);
                break;
            case 5:
                break;
            default:
                return;
        }

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
    
    public void mostraEroi(HashMap<EroeDescrizione,Integer> eroeDesc,boolean errore,boolean errorePrezzo,Giocatore giocatore){
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
        
        String s="Inserisci idEroe che vuole acquistare oppure 0 per tornare indietro";
        int idEroe=this.inserisci(s);
        if(idEroe==0){
            ViewIniziale view=new ViewIniziale();
            view.selezionaOperazione(giocatore);
        }
        else{
            s="Inserisci quantità eroi che vuole acquistare oppure 0 per annullare";
            int quantita=this.inserisci(s);
            if(quantita==0){
                this.mostraEroi(eroeDesc,false,false,giocatore);
            }
            else{
                acquista=new CAcquista(giocatore);
                acquista.acquistaEroi(idEroe,quantita);
            }
        }
    }
    
    public void conferma(int idEroeDescrizione,int quantita,Risorsa r,Giocatore giocatore){
        String s="Sei sicuro di voler acquistare "+quantita+" eroe/i con idEroeDescrizione:" +idEroeDescrizione+"?\n Il costo totale è di: "+r.toString()+"\n Premi 1 per confermare altro per annulla";
        int ris=this.inserisci(s);
        if(ris==1){
            acquista=new CAcquista(giocatore);
            this.acquista.conferma(true);
        }
        ViewIniziale view=new ViewIniziale();
        view.selezionaOperazione(giocatore);        
    }
    
}
