
package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.CAcquista;
import com.mycompany.progettoclash.CAttacca;
import com.mycompany.progettoclash.CInserisciEdificio;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.Casella;
import com.mycompany.progettoclash.EdificioDescrizione;
import com.mycompany.progettoclash.Eroe;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.Villaggio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewIniziale {
        ViewAttacco viewAttacco=new ViewAttacco();
        ViewAcquista viewAcquista=new ViewAcquista();
        ViewInserisci viewInserisci=new ViewInserisci();
        ViewPotenzia viewPotenzia=new ViewPotenzia();
    
        public void selezionaOperazione(Giocatore g,boolean errore){
            if(errore){
                System.out.println("EroiFiniti");
            }
        HashMap<String,Double> map=g.mostraRisorse();
            for (String name: map.keySet()) {
            String key = name;
            Double value = map.get(name);
            System.out.println(key + " " + value);
        }
        this.visualizzaVillaggio(g.getVillaggio());
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n >=5: Esci(logout)";

        int ris=this.inserisci(s);
        switch (ris) {
            case 1:
                CAttacca attacca=new CAttacca();
                attacca.cercaAvversario(g);
                break;
            case 2:
                CPotenzia potenzia=new CPotenzia(g);
                HashMap<EroeDescrizione,Integer> eroeDesc =potenzia.selezionaOperazione();
                //ViewPotenzia view=new ViewPotenzia();
                viewPotenzia.mostraEroi(eroeDesc, false, false,g);
                break;
            case 3:
                           
                CInserisciEdificio inserisci=new CInserisciEdificio(g);
                ArrayList<EdificioDescrizione>  desc=inserisci.selezionaOperazione();
                ViewInserisci view=new ViewInserisci(inserisci);
                view.mostraEdifici(desc,g);
                break;
            case 4:
                CAcquista acquista=new CAcquista(g);
                acquista.selezionaOperazione(g);
                break;
            case 5:
                return;
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
         } while (var <= 0);
         return var;
    }
    
    public void visualizzaVillaggio(Villaggio villaggioD){
        System.out.println();
        System.out.println("IL TUO VILLAGGIO");
        String s="";
        for (int i=1;i<=villaggioD.getAltezza();i++){
            s="";
            for (int j=1;j<=villaggioD.getLarghezza();j++){
                Casella c=villaggioD.getCasella(i, j); 
                s="Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ";
                if(c.getEdificio()!=null){
                    s=s+"Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getEdificioDescrizione().getStatistica().getVita()+" "+c.getEdificio().getEdificioDescrizione().getNome();
                }
                ArrayList<Eroe> er = c.getListaEroiA();
                for (int k=0;k<er.size();k++){
                    s=s+"IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita()+" ";                    
                }
                System.out.print(s);
                System.out.print("     ");
            }
            System.out.println();
        }
        System.out.println("");
    }   
    
}
