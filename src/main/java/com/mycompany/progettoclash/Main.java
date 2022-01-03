/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewSelezionaPosizionaEroe;

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
        Casella c=new Casella(2,3);
        //c.setPosizioneRiga(3);
       // c.setPosizioneColonna(2);
        Casella c2=new Casella(1,1);
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
        
        Giocatore ga=new Giocatore();
        g.setVillaggio(v);
        
        ClashGame clash=new ClashGame(ga,g);
// System.out.println(g.toString());
        //System.out.println(g.getVillaggio().getCaselle().get(1).getEdificio().getId());
        
        
        CPotenzia p=new CPotenzia();
          
       //SIMULAZIONE DEGLI Eroi che attaccano
        Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        guerriero.setC(c);
        guerriero.getModA().attacco(guerriero);
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
        
        
        ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();   
        ArrayList<Integer> arr=view.mostraSelezionaPosizionaEroe(new ArrayList<Eroe>());               
        SelezionePosizionaEroe sel=new SelezionePosizionaEroe(clash);
        sel.selezionaPosizionaEroe(arr);
        
    }
        
}
