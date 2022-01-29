/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash.view;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.Giocatore;
import java.util.Scanner;
/**
 *
 * @author Lorenzo
 */
public class ViewPotenzia {
    
    private CPotenzia potenzia;
    
    public void selezionaEdificio(Giocatore g){//attenzione, chi glielo passa g?
        
        
        //richiamo metodo altra classe ...
     /*   System.out.println("Cosa vuoi fare?");
        System.out.println("1: Attaccare un altro giocatore?");
        System.out.println("2: Potenziare eroe?");
        System.out.println("3: Inserire edificio?");
        System.out.println("4: Acquistare eroi?");
        System.out.println("5: Potenziare edificio?");
        System.out.println(">5: Esci(logout)");*/
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";
       // String s="Immetti riga Edificio";
        int ris=this.inserisci(s);
    //s="Immetti colonna Edificio";
    //int colonna=this.inserisci(s);
    
        potenzia=new CPotenzia();
        potenzia.operazione(g);
    
    }
    
    public void mostraEroi(){
        
    }
    
    private int inserisci(String strDaVisualizzare){
        
        int var=0;
        Scanner sc=new Scanner(System.in);
        do {
             System.out.println(strDaVisualizzare);
             while (!sc.hasNextInt()) {
                 System.out.println("Errore, immetti un numero");
                 sc.next(); 
             }
             var = sc.nextInt();
         } while (var <= 0);
         return var;
    }
    
    
}
