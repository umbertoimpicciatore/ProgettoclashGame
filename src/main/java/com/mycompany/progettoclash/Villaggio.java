
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Villaggio {
    
    private Giocatore giocatore;
    private int larghezza;
    private int altezza;
    private ArrayList<Casella> caselle = new ArrayList<Casella>();

    public ArrayList<Casella> getCaselle() {
        return caselle;
    }

    public void setCaselle(ArrayList<Casella> cars) {
        this.caselle = cars;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
    
    public Casella getCasella(int riga,int col){
        ArrayList<Casella> caselle2=this.giocatore.getVillaggio().getCaselle();
        Casella c;
        for(int i=0;i<caselle2.size();i++){
            c=caselle2.get(i);
            if(c.getPosizioneRiga()==riga & c.getPosizioneColonna()==col){
                return c;
            }
        }
        return null; 
    }
 
}
