
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewCercaAvversario;
import com.mycompany.progettoclash.view.ViewSelezionaPosizionaEroe;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ClashGame {
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    private StatoAttacco stato;
    
    /*public ClashGame(){
        stato=new AttaccanoEroi();
    }*/
    
    public ClashGame(Giocatore ga,Giocatore gd){
        //stato=new AttaccanoEroi();
        stato=null;
        this.giocatoreA=ga;
        this.giocatoreD=gd;
        //trovaAvversarrio per GIOCATORE DIF IMPLEMENTARE
    }

    public ClashGame() {
    }
    
    public void CambiaStato(StatoAttacco st){
        stato=st;
        //stato.esegui(this);
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
    
    public void iniziaBattaglia(int iniziaBattaglia){
         if(iniziaBattaglia==1){
            boolean fineBattaglia=false;
            while(fineBattaglia==false){
                
                stato=new AttaccanoEroi();
                stato.esegui(this);//attaccano eroi
                stato.esegui(this);//controllo fine battaglia
                stato.attaccanoEdifici(this);//attaccano edifici
                stato.esegui(this);//controllo fine batt
                stato.esegui(this);//sposta
            
            }
        }
        else{
            ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();
            view.mostraSelezionaPosizionaEroe(giocatoreA.getEroi());
        }       
       
    }
    //vedi a chi assegnarlo
    public void posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        Casella c=this.giocatoreD.getVillaggio().getCasella(riga, colonna);
        c.addEroi(listaEroi);
    }
    
    
}
