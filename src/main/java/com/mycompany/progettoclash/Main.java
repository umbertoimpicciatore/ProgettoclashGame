/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewSelezionaPosizionaEroe;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Main {
    public static void main(String[] args){
        Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Villaggio v=new Villaggio();
        Edificio e=new Municipio(new Immagazzinare(),new AttaccaAvanti());
        Statistica s=new Statistica(5,5,100);
        e.setStatistica(s);
        e.setId(1);
        ArciereBuilder arc=new ArciereBuilder();
        EroeDirector erD=new EroeDirector();
        Eroe eroeArc=erD.createEroe(arc);
        //Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        
       //creo VILLAGGIO
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c=new Casella(i,j);
                
                
                if(i==1 &&j==1){
                    c.AddEroe(eroeArc);
                    c.setEdificio(e);
                    eroeArc.setC(c);
                    e.setCasella(c);
                }
                
                c.setVillaggio(v);
                caselle.add(c);
            }
        }
        
        v.setCaselle(caselle);
        Giocatore ga=new Giocatore();
        g.setVillaggio(v);
        Objects.isNull(g.getVillaggio().getCasella(1, 1).getVillaggio());
        ClashGame clash=new ClashGame(ga,g);
        eroeArc.getModA().attacco(eroeArc);
        clash.iniziaBattaglia();
        
        
        Villaggio villaggioD=clash.getGiocatoreD().getVillaggio();
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
        
          /*
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
        
        */
          
     //   ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();   
       // ArrayList<Integer> arr=view.mostraSelezionaPosizionaEroe(new ArrayList<Eroe>());               
        //SelezionePosizionaEroe sel=new SelezionePosizionaEroe(clash);
        //sel.selezionaPosizionaEroe(arr);
        
    }
        
}
