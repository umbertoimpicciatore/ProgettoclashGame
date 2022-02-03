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
       // ClashGame clash=new ClashGame(giocatoreA,giocatoreD);
        ArrayList<Eroe> eroiA=giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);            
        }
        else{       
            boolean b=clash.posizionaEroe(riga, colonna, eroiA);
            if(!b){
                giocatoreA.getAccampamento().setListaEroiGiocatore(eroiA);//in caso di errori di immissione di riga e colonna rimetto gli eroi all'attaccante
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
}