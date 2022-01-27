
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewCercaAvversario;
import java.util.ArrayList;

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
        ViewCercaAvversario view=new ViewCercaAvversario();
        stato=new Attacco();
         if(iniziaBattaglia==1){
            boolean fineBattaglia=false;
            while(fineBattaglia==false){
                
               // System.out.println("CIAO loop");
                System.out.println();
                
                stato.attaccanoEroi(this);//attaccano eroi
                fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine battaglia
                if(fineBattaglia==false){
                    stato.attaccanoEdifici(this);//attaccano edifici
                    fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine batt
                    stato.controlloFineBattaglia(this);//sposta
                }
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
            }
        }
        else{
            //ViewCercaAvversario view=new ViewCercaAvversario();
            view.mostraSelezionaPosizionaEroe();
        }       
       
    }
    //vedi a chi assegnarlo
    public void posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        //manca controllo sulla casella
        Casella c=this.giocatoreD.getVillaggio().getCasella(riga, colonna);    
        for(int i=0;i<listaEroi.size();i++){//assegno a ciascun eroe la casella in cui verrà posizionato
            listaEroi.get(i).setC(c);
        }
        c.addEroi(listaEroi);
    }
    
    
}
