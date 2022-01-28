/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewCercaAvversario;


import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class SelezionePosizionaEroe {


    private ClashGame clash;
    
    public SelezionePosizionaEroe(){
    }
    
    public SelezionePosizionaEroe(ClashGame clash){
        
    this.clash=clash;
    
    }
    
    public void selezionaPosizionaEroe(int riga,int colonna,int idEroe,int quantita,Giocatore giocatoreA,Giocatore giocatoreD) {
        
        ViewCercaAvversario view=new ViewCercaAvversario();
        ClashGame clash=new ClashGame(giocatoreA,giocatoreD);
        //RIGUARDA ATTENTAMENTO PER IL NULL
        ArrayList<Eroe> eroiA=giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            //in caso di errori rifaccio fare la selezione posizione eroe
            view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);
            
        }
        else{       
            boolean b=clash.posizionaEroe(riga, colonna, eroiA);
            if(!b){
                giocatoreA.getAccampamento().setListaEroiGiocatore(eroiA);
                view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);
            }
            else{
                view.visualizzaVillaggio(giocatoreD.getVillaggio());
                view.iniziaBattaglia(clash);
            }
            
        }
    }   
}