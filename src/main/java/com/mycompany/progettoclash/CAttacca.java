package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewAttacco;
import com.mycompany.progettoclash.view.ViewIniziale;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CAttacca {

    private Giocatore giocatoreA;
    private Giocatore giocatoreD;


    public CAttacca(Giocatore giocatoreA) {
        this.giocatoreA = giocatoreA;
    }

    public CAttacca(Giocatore giocatoreA, Giocatore giocatoreD) {
        this.giocatoreA = giocatoreA;
        this.giocatoreD = giocatoreD;
    }
    
    
    public void cercaAvversario(){
        ViewAttacco view=new ViewAttacco();
        Giocatore giocatoreD=giocatoreA.cercaAvversario();
        this.giocatoreD=giocatoreD;
        view.conferma(giocatoreD, giocatoreA);
    }

    public void selezionaPosizionaEroe(int riga,int colonna,int idEroe,int quantita) {
        
        ViewAttacco view=new ViewAttacco();
        HashMap<EroeDescrizione,Integer> map=this.giocatoreA.getAccampamento().mostraEroiDescQuantita();
        ArrayList<Eroe> eroiA=this.giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            
            view.mostraSelezionaPosizionaEroe(this.giocatoreA, this.giocatoreD, true,map);            
        }
        else{       
            boolean b=this.posizionaEroe(riga, colonna, eroiA);//ho modificato questo
            if(!b){
                this.giocatoreA.getAccampamento().addEroi(eroiA);//in caso di errori di immissione di riga e colonna rimetto gli eroi all'attaccante
                view.mostraSelezionaPosizionaEroe(this.giocatoreA, this.giocatoreD, true,map);
            }
            else{
                map=this.giocatoreA.getAccampamento().mostraEroiDescQuantita();
                view.visualizzaVillaggio(this.giocatoreD.getVillaggio());
                if(giocatoreA.getEroi().size()>0){
                    view.iniziaBattaglia(this.giocatoreA,this.giocatoreD,false,map);
                }
                else{
                    view.iniziaBattaglia(this.giocatoreA,this.giocatoreD,true,map);
                }
            }
            
        }
    }
    
    public boolean posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        Villaggio v=this.giocatoreD.getVillaggio();
        boolean b=v.posizioneEore(riga, colonna, listaEroi);
        return b;
    }
    
    public void conferma(){
        
        HashMap<EroeDescrizione,Integer> map=giocatoreA.getAccampamento().mostraEroiDescQuantita();
        ViewAttacco view=new ViewAttacco();
        view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, false,map);

    }
    
    public void iniziaBattaglia(){
        Battaglia b=new Battaglia(this.giocatoreA,this.giocatoreD);
        ArrayList<Risorsa> risorse=b.iniziaBattaglia();
        ViewAttacco viewA=new ViewAttacco();
        viewA.mostraRisorseRubate(risorse);
        this.giocatoreA.getVillaggio().addRisorse(risorse);
        this.giocatoreD.getVillaggio().perdiRisorse();
        ViewIniziale viewI=new ViewIniziale();
        viewI.selezionaOperazione(this.giocatoreA);
        
    }
    
    
}