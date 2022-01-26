/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.Casella;
import com.mycompany.progettoclash.ClashGame;
import com.mycompany.progettoclash.Eroe;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.SelezionePosizionaEroe;
import com.mycompany.progettoclash.Villaggio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewCercaAvversario {
    
    public void cercaAvversario(Giocatore giocatoreA){
    
        Scanner sc=new Scanner(System.in); 
        int riga;
         do {
             System.out.println("Immetti numero positivo per iniziare battaglia ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             riga = sc.nextInt();
         } while (riga < 0);
         if (riga==0){
             //torna indietro,annulla
         }
        
        giocatoreA.cercaAvversario();
        
    }
    
    public void conferma(Giocatore giocatoreD,Giocatore giocatoreA){
        this.visualizzaVillaggio(giocatoreD.getVillaggio());
        Scanner sc=new Scanner(System.in); 
        int riga;
         do {
             System.out.println("Immetti 1 per confermare, 2 per cercare un altro avversaio, altro per uscire ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             riga = sc.nextInt();
         } while (riga < 0);
         if (riga==0){
             //torna indietro,annulla
         }
         switch(riga) {
             
            case 1: this.mostraSelezionaPosizionaEroe(giocatoreA,giocatoreD,false);
            
            break;
                case 2: giocatoreA.cercaAvversario();
            
            break;
            // eventuali altri case
            case 3: break;
            
            default:
            }
    }
    
    private void visualizzaVillaggio(Villaggio villaggioD){
        for (int i=1;i<=villaggioD.getAltezza();i++){
            for (int j=1;j<=villaggioD.getLarghezza();j++){
                Casella c=villaggioD.getCasella(i, j);
                
                //System.out.print(Objects.isNull(c));
                System.out.print("Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ");
                if(c.getEdificio()!=null){
                    System.out.print("Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ");

                }
                ArrayList<Eroe> er = c.getListaEroiA();
                for (int k=0;k<er.size();k++){
                    System.out.print("IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita());
                    
                }
                System.out.print("     ");
                
            }
            System.out.println();
        }
    }
    
    public void mostraSelezionaPosizionaEroe(Giocatore giocatoreA,Giocatore giocatoreD,boolean errore){
        
        ArrayList<Eroe> eroiA=giocatoreA.getEroi();//implementa
        System.out.println("Arciere id 10");
        if(errore==true){
            System.out.println("Quantita immessa errata o id eroe sbagliato");
        }
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
         
         //DA TOGLIERE
         int iniziaBattaglia = 0;
         do {
             System.out.println("Vuoi iniziare la battaglia? Inserisci 1 per confermare altrimenti 0 per continuare a immettere eroi ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             iniziaBattaglia = sc.nextInt();
         } while (iniziaBattaglia < 0);
         if (iniziaBattaglia==0){
             //torna indietro,annulla
         }
         
        SelezionePosizionaEroe sel= new SelezionePosizionaEroe();
        sel.selezionaPosizionaEroe(riga,colonna,idEroe,quantita,iniziaBattaglia,giocatoreA,giocatoreD);
        }
    
    public void iniziaBattaglia(ClashGame clash){
        Scanner sc=new Scanner(System.in); 
        int iniziaBattaglia = 0;
         do {
             System.out.println("Vuoi iniziare la battaglia? Inserisci 1 per confermare altrimenti 0 per continuare a immettere eroi ");
             while (!sc.hasNextInt()) {
                 System.out.println("Immetti un numero");
                 sc.next(); 
             }
             iniziaBattaglia = sc.nextInt();
         } while (iniziaBattaglia < 0);
         if (iniziaBattaglia==0){
             //torna indietro,annulla
         }
         clash.iniziaBattaglia(iniziaBattaglia);
    
    }
    
}
