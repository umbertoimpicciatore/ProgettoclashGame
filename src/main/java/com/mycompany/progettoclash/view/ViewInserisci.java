
package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.CInserisciEdificio;
import com.mycompany.progettoclash.EdificioDescrizione;
import com.mycompany.progettoclash.Giocatore;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewInserisci {
    
    CInserisciEdificio inserisci;
    
    public void selezionaOperazione(Giocatore g){
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";

        int ris=this.inserisci(s);
        switch (ris) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                inserisci=new CInserisciEdificio(g);
                ArrayList<EdificioDescrizione>  desc=inserisci.operazione(g);
                this.mostraEdifici(desc);
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                return;
        }
   
    }
    

    public void mostraEdifici( ArrayList<EdificioDescrizione> desc){
        for(int i=0;i<desc.size();i++){
            System.out.println(desc.toString());
        }
        String s="Inserisci idEdificio che vuole acquistare oppure 0 per annullare";
        int idEdif=this.inserisci(s);
        if(idEdif==0){
            return;
        }
        else{
            
            boolean b=inserisci.operazione10(idEdif);
            if(!b){
                this.mostraEdifici(desc);
            }
            else{
                this.selezionaRigaColonna(idEdif);
            }
        }
    }
   
    
    public void selezionaRigaColonna(int idEdif){
        
        String s="Inserisci riga in cui vuoi inserire edificio";
        int riga=this.inserisci(s);
        s="Inserisci colonna in cui vuoi inserire edificio";
        int  colonna=this.inserisci(s);
        boolean b=inserisci.operazione11(riga,colonna);
        if(b){
            this.conferma(idEdif,riga,colonna);
        }
        else{
            this.selezionaRigaColonna(idEdif);
        }
    }
    
    
    public void conferma(int idEdif,int riga,int colonna){
        
        String s="Inserisci 1 per confermare, >1 per annullare";
        int ris=this.inserisci(s);
        inserisci.conferma2(idEdif,riga,colonna);
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
