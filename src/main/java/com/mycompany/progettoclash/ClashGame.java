
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewCercaAvversario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class ClashGame {
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    private StatoAttacco stato;
    
    
    public ClashGame(Giocatore ga,Giocatore gd){
        //stato=new AttaccanoEroi();
        stato=null;
        this.giocatoreA=ga;
        this.giocatoreD=gd;
    }
     public ClashGame(Giocatore ga){
        //stato=new AttaccanoEroi();
        stato=null;
        this.giocatoreA=ga;
    }

    public ClashGame() {
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
    
    public void cercaAvversario(){
        
        TrovaAvversario t=new TrovaAvversario();
        Giocatore giocatoreD=null;
        giocatoreD = t.getAvversario(this.giocatoreA);
        ViewCercaAvversario view=new ViewCercaAvversario();//si può fare dentro il controller?
        view.conferma(giocatoreD,this.giocatoreA); 
    }
    
    public void iniziaBattaglia(){
        ViewCercaAvversario view=new ViewCercaAvversario();
        stato=new Attacco();
        boolean fineBattaglia=false;
            while(fineBattaglia==false){                
               // System.out.println("CIAO loop");
                
                
                stato.attaccanoEroi(this);//attaccano eroi
                fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine battaglia
                if(fineBattaglia==false){
                    stato.attaccanoEdifici(this);//attaccano edifici
                    fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine batt
                    stato.spostaEroi(this);//sposta
                }
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
            }
        
               
       
    }
    //vedi a chi assegnarlo
    //restituisce false in caso di problemi, true nel caso in cui l'esecuzione è andata a buon fine
    public boolean posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        //manca controllo sulla casella
        Villaggio v=this.giocatoreD.getVillaggio();
        if(riga>v.getAltezza() || colonna>v.getLarghezza()){
            return false;
        }
        else{
            Casella c=v.getCasella(riga, colonna);    
            for(int i=0;i<listaEroi.size();i++){//assegno a ciascun eroe la casella in cui verrà posizionato
                listaEroi.get(i).setC(c);
            }
            c.addEroi(listaEroi);
            return true;
        }
        
    }
    
    
}
