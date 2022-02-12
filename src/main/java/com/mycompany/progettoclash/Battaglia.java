
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.BattagliaF;
import com.mycompany.progettoclash.Foundation.PersistanManager;
import com.mycompany.progettoclash.view.ViewAttacco;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Battaglia {
    
    private int id;
    private Giocatore giocatoreA;
    private Giocatore giocatoreD;
    private StatoAttacco stato;

    public Giocatore getGiocatoreA() {
        return giocatoreA;
    }

    public Battaglia(Giocatore giocatoreA, Giocatore giocatoreD) {
        this.giocatoreA = giocatoreA;
        this.giocatoreD = giocatoreD;
        this.id=BattagliaPersistant.getInstance().getUltimoId()+1;
        BattagliaPersistant.getInstance().setUltimoId(id);
        BattagliaPersistant.getInstance().setBattaglia(this);
    }

    public void setGiocatoreA(Giocatore giocatoreA) {
        this.giocatoreA = giocatoreA;
    }

    public Giocatore getGiocatoreD() {
        return giocatoreD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public void CambiaStato(StatoAttacco st){
        stato=st;
    }
    
    public ArrayList<Casella> caselleDifensore(){
        
        return giocatoreD.getVillaggio().getCaselle();
    }

    
    public ArrayList<Risorsa> iniziaBattaglia(){
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
        OttenimentoRisorseStrategy strategy= OttenimentoRisorseFactory.getInstance().getStrategy();
        ArrayList<Risorsa>risorse=strategy.ottieniRisorsa(this);
        this.eroiVivi(this.caselleDifensore(), giocatoreA);
        return risorse;




    }
    
        //prende in ingresso le caselle del villaggio difensore e il giocatore Attaccante
    //gli eroiVivi delGIocatore Attaccante tornano all'attaccante se non sono morti
    private void eroiVivi( ArrayList<Casella> caselle,Giocatore giocatoreA){
        ArrayList<Eroe> eroiA=new ArrayList<Eroe>();
        for (int i=0;i<caselle.size();i++){
            ArrayList<Eroe> eroi=caselle.get(i).getListaEroiA();
            if(eroi!=null && eroi.size()>0){
                eroiA.addAll(eroi);
                this.ripristinaVita(eroi);
                caselle.get(i).setListaEroiA(new ArrayList<Eroe>());//tolgo gli eroi attaccanti sulla casella del villaggio difensore
            }
        }
        giocatoreA.getAccampamento().addEroi(eroiA);
    }
    private void ripristinaVita(ArrayList<Eroe> eroi){
        for(int i=0;i<eroi.size();i++){ 
            int vitaMax=eroi.get(i).getEroeDescrizione().getVitaMassima();
            eroi.get(i).setVita(vitaMax);
        }
    
    }
    
    
}
