
package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.CAcquista;
import com.mycompany.progettoclash.CInserisciEdificio;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.ClashGame;
import com.mycompany.progettoclash.Giocatore;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewIniziale {
        ClashGame clash;
        ViewAttacco viewAttacco=new ViewAttacco();
        ViewAcquista viewAcquista=new ViewAcquista();
        ViewInserisci viewInserisci=new ViewInserisci();
        ViewPotenzia viewPotenzia=new ViewPotenzia();
    
        public void selezionaOperazione(Giocatore g){//attenzione, chi glielo passa g?
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n >=5: Esci(logout)";

        int ris=this.inserisci(s);
        switch (ris) {
            case 1:
                clash=new ClashGame(g);
                clash.cercaAvversario();
                break;
            case 2:
                CPotenzia potenzia=new CPotenzia(g);
                potenzia.operazione();
                break;
            case 3:
                CInserisciEdificio inserisci=new CInserisciEdificio(g);
                inserisci.operazione(g);
                break;
            case 4:
                CAcquista acquista=new CAcquista(g);
                //CAcquista.getInstance(g).operazione(g);
                acquista.operazione(g);
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
    
}
