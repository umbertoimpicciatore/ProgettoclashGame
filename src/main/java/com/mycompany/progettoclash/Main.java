/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Main {
    public static void main(String[] args){
        Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        Villaggio v=new Villaggio();
        Casella c=new Casella();
        c.setPosizioneRiga(3);
        c.setPosizioneColonna(2);
        Casella c2=new Casella();
        //Edificio e=new Edificio();
        Edificio e=new Municipio(new Immagazzinare(),new NonAttacca());
        e.setId(1);
        //Edificio e2=new Edificio();
        //e2.setId(2);
        c.setEdificio(e);
        //c2.setEdificio(e2);
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        caselle.add(c);
        caselle.add(c2);
        v.setCaselle(caselle);
        
        g.setVillaggio(v);
       // System.out.println(g.toString());
        //System.out.println(g.getVillaggio().getCaselle().get(1).getEdificio().getId());
        
        
        CPotenzia p=new CPotenzia();
        
        Scanner sc=new Scanner(System.in);  
        
        
        /*System.out.println("Immetti riga edificio da selezionare: ");  
        int r= sc.nextInt();  
       
        
        System.out.println("Immetti colonna edificio da selezionare: ");  
        int col= sc.nextInt(); 
        
        Casella c3=p.selezionaEdificio(r, col,g);
        System.out.println(c3.getPosizioneColonna());
        System.out.println(c3.getPosizioneRiga());*/
        
        
       
       
       /*CONTROLLO INPUT DA TASTIERA PER INSERIMENTO DI SELEZIONA EDIFICIO
             
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
       
       
       */
       
       //SIMULAZIONE DEGLI Eroi che attaccano
        Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        guerriero.setC(c);
        guerriero.modA.attacco(guerriero);
       //guerriero.attacca();
         Eroe arciere=new Arciere(new AttaccaDuePosizioni(),2);
      // arciere.attacca();
      
        arciere.setC(c);
        guerriero.setC(c);
        ArrayList<Eroe> eroi = new ArrayList<Eroe>();
        eroi.add(arciere);
        eroi.add(guerriero);
        for (int i=0;i<eroi.size();i++){
            
           // eroi.get(i).attacca();
            System.out.println(eroi.get(i).getId());
           // System.out.println(eroi.get(i).getC().getPosizioneRiga());

        }
        
        
        ArciereBuilder arc=new ArciereBuilder();
        EroeDirector erD=new EroeDirector();
        Eroe eroeArc=erD.createEroe(arc);
        Eroe arcPot=erD.createEroePotenziato(arc);
        System.out.println(eroeArc.toString());
        System.out.println(arcPot.toString());
        
               
    }
        
}
