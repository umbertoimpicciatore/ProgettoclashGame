/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view;


import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class SelezionePosizionaEroe {

    private int quantità;
    private int idEroe;
    private int riga;
    private int colonna;
    private ClashGame clash;
    


    
    public void selezionaPosizionaEroe(ArrayList<Integer> risultati) {
        int riga=risultati.get(0);
        int colonna=risultati.get(1);
        int quantita=risultati.get(3);
        int iniziaBattaglia=risultati.get(4);
        ArrayList<Eroe> eroiA=clash.getGiocatoreA().getEroi();
        Casella c=clash.getGiocatoreD().getVillaggio().getCasella(riga, colonna);
        //manca il controllo se quantità è minore uguale degli eroi disponibili
        for(int i=0;i<eroiA.size() || i<quantita;i++){
            c.AddEroe(eroiA.get(i));
        }
        if(iniziaBattaglia==1){
           // clash.CambiaStato(st);//esegui stato boh
            
        }
        else{
            ViewSelezionaPosizioneEroe view=new ViewSelezionaPosizioneEroe();
            view.mostraSelezionaEroe();
        }
    }
    
   
    
}
