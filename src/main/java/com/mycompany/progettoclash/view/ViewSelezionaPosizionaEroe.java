/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.Eroe;
import com.mycompany.progettoclash.Eroe;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewSelezionaPosizionaEroe {
     //CONTROLLO INPUT DA TASTIERA PER INSERIMENTO DI SELEZIONA EDIFICIO
              
        public ArrayList<Integer> mostraSelezionaPosizionaEroe(ArrayList<Eroe> eroiA){
            
            System.out.println("Arciere id 10");
            
            
            
        Scanner sc=new Scanner(System.in); 
        int riga;
         do {
             System.out.println("Immetti riga edificio da selezionare: ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             riga = sc.nextInt();
         } while (riga < 0);
         if (riga==0){
             //torna indietro,annulla
         }
         System.out.println("Riga " + riga);
         
         //immissione colonna
         int colonna;
         do {
             System.out.println("Immetti colonna edificio da selezionare: ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             colonna = sc.nextInt();
         } while (colonna < 0);
         if (colonna==0){
             //torna indietro,annulla
         }
         System.out.println("Colonna " + colonna+ "Riga "+ riga);
       
         int idEroe = 0;
         do {
             System.out.println("Immetti idEroe edificio da selezionare: ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             idEroe = sc.nextInt();
         } while (idEroe < 0);
         if (idEroe==0){
             //torna indietro,annulla
         }
         
         int quantita = 0;
         do {
             System.out.println("Immetti quantità edificio da selezionare: ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             quantita = sc.nextInt();
         } while (quantita < 0);
         if (quantita==0){
             //torna indietro,annulla
         }
         
         int iniziaBattaglia = 0;
         do {
             System.out.println("Vuoi iniziare la battaglia? Inserisci 1 per confermare altrimenti 0 per continuare a immettere eroi ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             iniziaBattaglia = sc.nextInt();
         } while (quantita < 0);
         if (quantita==0){
             //torna indietro,annulla
         }
         
         ArrayList<Integer> risultati=new ArrayList<Integer>();
         risultati.add(riga);
         risultati.add(colonna);
         risultati.add(idEroe);
         risultati.add(quantita);
         risultati.add(iniziaBattaglia);
         return risultati;
        }
        
        
       
       
       
}
