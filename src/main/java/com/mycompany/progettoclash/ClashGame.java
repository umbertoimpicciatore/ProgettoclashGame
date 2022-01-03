
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ClashGame {
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    private StatoAttacco stato;
    
    public ClashGame(){
        stato=new AttaccanoEroi();
    }
    
    public ClashGame(Giocatore ga,Giocatore gd){
        //stato=new AttaccanoEroi();
        stato=null;
        this.giocatoreA=ga;
        this.giocatoreD=gd;
        //trovaAvversarrio per GIOCATORE DIF IMPLEMENTARE
    }
    
    public void CambiaStato(StatoAttacco st){
        stato=st;
    }

    public Giocatore getGiocatoreA() {
        return giocatoreA;
    }

    public void setGiocatoreA(Giocatore giocatoreA) {
        this.giocatoreA = giocatoreA;
    }

    public Giocatore getGiocatoreD() {
        return giocatoreD;
    }

    public void setGiocatoreD(Giocatore giocatoreD) {
        this.giocatoreD = giocatoreD;
    }

    public StatoAttacco getStato() {
        return stato;
    }

    public void setStato(StatoAttacco stato) {
        this.stato = stato;
    }
    
    public ArrayList<Casella> caselleDifensore(){
        
        return giocatoreD.getVillaggio().getCaselle();
    }
    
    public void iniziaBattaglia(){
        
        stato=new AttaccanoEroi();
        stato.esegui(this);
        
    }
    /*
    public void attaccaEroe(){
        //Villaggio v=giocatoreD.getVillaggio();
        //v.getCaselle();
        //this.caselleDifensore();
        for(int i=0;i< this.caselleDifensore().size();i++){
            Casella c= this.caselleDifensore().get(i);
            ArrayList<Eroe> listE = c.getListaEroiA();
                    if(listE!=null){
                        for(int j=0;j<listE.size();j++){
                            Eroe e=listE.get(j);
                            //e.attacca();
                        }
            }
        }
    }*/
    
}
