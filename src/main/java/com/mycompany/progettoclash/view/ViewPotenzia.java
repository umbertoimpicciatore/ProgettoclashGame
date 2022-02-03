/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash.view;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.Risorsa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Lorenzo
 */
public class ViewPotenzia {
    
    private CPotenzia potenzia;
    
    public void selezionaOperazione(Giocatore g){//attenzione, chi glielo passa g?
        
        
        //richiamo metodo altra classe ...
     /*   System.out.println("Cosa vuoi fare?");
        System.out.println("1: Attaccare un altro giocatore?");
        System.out.println("2: Potenziare eroe?");
        System.out.println("3: Inserire edificio?");
        System.out.println("4: Acquistare eroi?");
        System.out.println("5: Potenziare edificio?");
        System.out.println(">5: Esci(logout)");*/
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";
        int ris=this.inserisci(s);
        potenzia=new CPotenzia(g);
        potenzia.operazione();
    
    }
    
    public void mostraEroi(HashMap<EroeDescrizione,Integer> eroeDesc,boolean errore,boolean errorePrezzo,Giocatore g){
        
        if(errore){
            System.out.println("IdEroe inserito non corretto");
        }
        if(errorePrezzo){
            System.out.println("Non hai a disposizione risorse sufficenti");
        }
        
        for (EroeDescrizione name: eroeDesc.keySet()) {
            String key = name.toString();
            String value = eroeDesc.get(name).toString();
            System.out.println(key + " " + value);
        }
        
        
        
        /*for (int i=0;i<eroeDesc.size();i++){
            
           System.out.println(eroeDesc.get(i).toString()+" Livello: "+eroeDesc.get(i).getEroi().get(i).getLivello());
        }*/
        String s="Inserisci idEroe da potenziare oppure 0 per annullare";
        int ris=this.inserisci(s);
        if(ris==0){
            return;
        }
        else{
            potenzia=new CPotenzia(g);
            potenzia.potenzia(ris);
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
    
     public void conferma(int idEroeDescrizione,Risorsa r,Giocatore g){
        String s="Sei sicuro di voler potenziare l' eroe con idEroeDescrizione:" +idEroeDescrizione+"?\n Il costo di potenziamento è di: "+r.toString()+"\n Premi 1 per confermare altro per annulla";
        int ris=this.inserisci(s);
        potenzia=new CPotenzia(g);
        potenzia.conferma(true, idEroeDescrizione);//da cambiare
    }
    
    
}
