
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Giocatore {
    private int livello;

    
    private String nome;
    private Villaggio villaggio;

    public Villaggio getVillaggio() {
        return villaggio;
    }

    public void setVillaggio(Villaggio v) {
        this.villaggio = v;
    }
public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Eroe> getEroi(){
         Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        //guerriero.setC(c);
//        guerriero.getModA().attacco(guerriero);
       //guerriero.attacca();
         Eroe arciere=new Arciere(new AttaccaDuePosizioni(),2);
      // arciere.attacca();
      
        //arciere.setC(c);
        //guerriero.setC(c);
        ArrayList<Eroe> eroi = new ArrayList<Eroe>();
        eroi.add(arciere);
        eroi.add(guerriero);
        return eroi;//da implementare
    }
    
    
}
