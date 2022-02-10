
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
    
    public ViewInserisci(CInserisciEdificio inserisci){
       this.inserisci=inserisci; 
    }
    public ViewInserisci(){
    }
    
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
                ArrayList<EdificioDescrizione>  desc=inserisci.operazione();
                this.mostraEdifici(desc,g);
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                return;
        }
   
    }
    

    public void mostraEdifici( ArrayList<EdificioDescrizione> desc,Giocatore g){
        for(int i=0;i<desc.size();i++){
            System.out.println(desc.get(i).toString());
        }
        String s="Inserisci idEdificio che vuole acquistare oppure 0 per annullare";
        int idEdif=this.inserisci(s);
        if(idEdif==0){
            ViewIniziale view=new ViewIniziale();
            view.selezionaOperazione(g);
        }
        else{
            
            boolean b=inserisci.operazione10(idEdif);
            if(!b){
                System.out.println("Quantita Massima Edificio raggiunta o risorse non disponibili o idEDIFICIO non trovato ");
                this.mostraEdifici(desc,g);
            }
            else{
                this.selezionaRigaColonna(idEdif,g);
            }
        }
    }
   
    
    public void selezionaRigaColonna(int idEdif,Giocatore g){
        
        String s="Inserisci riga in cui vuoi inserire edificio";
        int riga=this.inserisci(s);
        s="Inserisci colonna in cui vuoi inserire edificio";
        int  colonna=this.inserisci(s);
        boolean b=inserisci.operazione11(riga,colonna);
        if(b){
            this.conferma(idEdif,riga,colonna,g);
        }
        else{
            System.out.println("Edificio già presente in quella posizione, o riga e colonna inserito è sbagliato");
            this.selezionaRigaColonna(idEdif,g);
        }
    }
    
    
    public void conferma(int idEdif,int riga,int colonna,Giocatore g){
        
        String s="Inserisci 1 per confermare, >1 per annullare";
        int ris=this.inserisci(s);
        inserisci.conferma2();
        ViewIniziale view=new ViewIniziale();
        view.selezionaOperazione(g);
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
