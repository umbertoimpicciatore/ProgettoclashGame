
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Villaggio {
    
    private Giocatore giocatore;
    private int larghezza=4;
    private int altezza=4;
    private ArrayList<Casella> caselle = new ArrayList<Casella>();

    public ArrayList<Casella> getCaselle() {
        return caselle;
    }
    
   /* public Edificio cercaAccampamento(){
        Edificio e;
        for(int i=0;i<caselle.size();i++){
            e.getCasella().getEdificio().
        }
    
    }*/

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
//        ArrayList<Casella> caselle2=this.giocatore.getVillaggio().getCaselle();
        Casella c;
        for(int i=0;i<caselle.size();i++){
            c=caselle.get(i);
            if(c.getPosizioneRiga()==riga && c.getPosizioneColonna()==col){
                 return c;
               
            }
        }
        return null; 
    }
    
    public void setCasella(Casella c){
//        ArrayList<Casella> caselle2=this.giocatore.getVillaggio().getCaselle();
        Casella c2;
        for(int i=0;i<caselle.size();i++){
            c2=caselle.get(i);
            if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                caselle.set(i, c);
            }
        }
    }
 
}
