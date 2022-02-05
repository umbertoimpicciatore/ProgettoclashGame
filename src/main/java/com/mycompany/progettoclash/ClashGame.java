
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewAttacco;
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
        try {
            giocatoreD = t.getAvversario(this.giocatoreA);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ClashGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewAttacco view=new ViewAttacco();//si può fare dentro il controller?
        view.conferma(giocatoreD,this.giocatoreA); 
    }

    public void iniziaBattaglia(){
        ViewAttacco view=new ViewAttacco();
        stato=new Attacco();
        boolean fineBattaglia=false;
            while(fineBattaglia==false){                
                stato.attaccanoEroi(this);//attaccano eroi
                fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine battaglia
                if(fineBattaglia==false){
                    stato.attaccanoEdifici(this);//attaccano edifici
                    fineBattaglia=stato.controlloFineBattaglia(this);//controllo fine batt
                    stato.spostaEroi(this);//sposta
                }
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
            }
        OttenimentoRisorseStrategy strategy=null;    
        try {
             strategy=OttenimentoRisorseFactory.getInstance().getStrategy();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ClashGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Risorsa>risorse=strategy.ottieniRisorsa(this);
        this.giocatoreA.getVillaggio().addRisorse(risorse);
        this.giocatoreD.getVillaggio().perdiRisorse();
        this.eroiVivi(this.caselleDifensore(), giocatoreA);
        
    }
    
    //prende in ingresso le caselle del villaggio difensore e il giocatore Attaccante
    //gli eroiVivi delGIocatore Attaccante tornano all'attaccante se non sono morti
    private void eroiVivi( ArrayList<Casella> caselle,Giocatore giocatoreA){
        ArrayList<Eroe> eroiA=new ArrayList<Eroe>();
        for (int i=0;i<caselle.size();i++){
            ArrayList<Eroe> eroi=caselle.get(i).getListaEroiA();
            if(eroi!=null && eroi.size()>0){
                eroiA.addAll(eroi);
                caselle.get(i).setListaEroiA(new ArrayList<Eroe>());//tolgo gli eroi attaccanti sulla casella del villaggio difensore
            }
        }
        giocatoreA.getAccampamento().setListaEroiGiocatore(eroiA);
    }
    
    
    
    //vedi a chi assegnarlo
    //restituisce false in caso di problemi, true nel caso in cui l'esecuzione è andata a buon fine
 /*   public boolean posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        Villaggio v=this.giocatoreD.getVillaggio();
        boolean b=v.posizioneEore(riga, colonna, listaEroi);
        return b;
    }
    */
    
}
