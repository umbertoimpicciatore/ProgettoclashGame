/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash.view;
import com.mycompany.progettoclash.CPotenzia;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import java.util.ArrayList;
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
        int ris=this.inserisci(s);
        potenzia=new CPotenzia();
        potenzia.operazione(g);
    
    }
    
    public void mostraEroi(ArrayList<EroeDescrizione> desc,boolean errore){
        
        if(errore){
            System.out.println("IdEroe inserito non corretto");
        }
        
        for (int i=0;i<desc.size();i++){
           System.out.println(desc.get(i).toString()+" Livello: "+desc.get(i).getEroi().get(i).getLivello());
        }
        String s="Inserisci idEroe da potenziare oppure 0 per annullare";
        int ris=this.inserisci(s);
        potenzia.potenzia(ris);
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
