package com.mycompany.progettoclash;
import com.mycompany.progettoclash.Foundation.GiocatoreF;
import com.mycompany.progettoclash.Foundation.PersistanManager;
import com.mycompany.progettoclash.view.ViewAttacco;
import com.mycompany.progettoclash.view.ViewIniziale;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class CAttacca {
    
    public void cercaAvversario(Giocatore giocatoreA){
        ViewAttacco view=new ViewAttacco();
        Giocatore giocatoreD=giocatoreA.cercaAvversario();
        Battaglia b=new Battaglia(giocatoreA,giocatoreD);
        int idB=b.getId();
        view.conferma(giocatoreD,giocatoreA,idB);
    }

    public void selezionaPosizionaEroe(int riga,int colonna,int idEroe,int quantita,int idBattaglia) {
        Battaglia batt= BattagliaPersistant.getInstance().getBattaglia(idBattaglia);
        //Battaglia batt=p.getBattaglia(idBattaglia);
        Giocatore giocatoreA=batt.getGiocatoreA();
        Giocatore giocatoreD=batt.getGiocatoreD();
        ViewAttacco view=new ViewAttacco();
        HashMap<EroeDescrizione,Integer> map=giocatoreA.getAccampamento().mostraEroiDescQuantita();
        ArrayList<Eroe> eroiA=giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            
            view.mostraSelezionaPosizionaEroe(true,map,batt.getId());            
        }
        else{       
            boolean b=this.posizionaEroe(riga, colonna, eroiA,giocatoreD);//ho modificato questo
            if(!b){
                giocatoreA.getAccampamento().addEroi(eroiA);//in caso di errori di immissione di riga e colonna rimetto gli eroi all'attaccante
                view.mostraSelezionaPosizionaEroe( true,map,batt.getId());
            }
            else{
                map=giocatoreA.getAccampamento().mostraEroiDescQuantita();
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
                if(giocatoreA.getEroi().size()>0){
                    view.iniziaBattaglia(false,map,batt.getId());
                }
                else{
                    view.iniziaBattaglia(true,map,batt.getId());
                }
            }           
        }
    }
    
    public boolean posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi,Giocatore giocatoreD){
        Villaggio v=giocatoreD.getVillaggio();
        boolean b=v.posizioneEore(riga, colonna, listaEroi);
        return b;
    }
    
    public void conferma(int idBattaglia){
        Battaglia b= BattagliaPersistant.getInstance().getBattaglia(idBattaglia);
        HashMap<EroeDescrizione,Integer> map=b.getGiocatoreA().getAccampamento().mostraEroiDescQuantita();
        ViewAttacco view=new ViewAttacco();
        view.mostraSelezionaPosizionaEroe( false,map,b.getId());
    }
    
    public void iniziaBattaglia(int idBattaglia){
        Battaglia b= BattagliaPersistant.getInstance().getBattaglia(idBattaglia);
        ArrayList<Risorsa> risorse=b.iniziaBattaglia();
        ViewAttacco viewA=new ViewAttacco();
        viewA.mostraRisorseRubate(risorse);
        b.getGiocatoreA().getVillaggio().addRisorse(risorse);
        b.getGiocatoreD().getVillaggio().perdiRisorseRipristinaVita();
        ViewIniziale viewI=new ViewIniziale();
        viewI.selezionaOperazione(b.getGiocatoreA());
        
    }
    
    
}