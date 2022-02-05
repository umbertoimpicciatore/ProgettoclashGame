package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewAttacco;


import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class SelezionePosizionaEroe {

    
    public SelezionePosizionaEroe(){
    }
    

    public void selezionaPosizionaEroe(int riga,int colonna,int idEroe,int quantita,Giocatore giocatoreA,Giocatore giocatoreD) {
        
        ViewAttacco view=new ViewAttacco();
        ClashGame clash=new ClashGame(giocatoreA,giocatoreD);
        ArrayList<Eroe> eroiA=giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);            
        }
        else{       
            boolean b=this.posizionaEroe(riga, colonna, eroiA,giocatoreD);//ho modificato questo
            if(!b){
                giocatoreA.getAccampamento().addEroi(eroiA);//in caso di errori di immissione di riga e colonna rimetto gli eroi all'attaccante
                view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);
            }
            else{
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
                if(giocatoreA.getEroi().size()>0){
                    view.iniziaBattaglia(clash,false);
                }
                else{
                    view.iniziaBattaglia(clash,true);
                }
                
            }
            
        }
    }
    
    public boolean posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi,Giocatore giocatoreD){
        Villaggio v=giocatoreD.getVillaggio();
        boolean b=v.posizioneEore(riga, colonna, listaEroi);
        return b;
    }
}