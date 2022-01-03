/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewSelezionaPosizionaEroe;


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
    

    public SelezionePosizionaEroe(ClashGame clash){
        
    this.clash=clash;
    
    }
    
    public void selezionaPosizionaEroe(ArrayList<Integer> risultati) {
        int riga=risultati.get(0);
        int colonna=risultati.get(1);
        int idEroe=risultati.get(2);
        int quantita=risultati.get(3);
        int iniziaBattaglia=risultati.get(4);
        int cont=0;
        ArrayList<Eroe> eroiA=clash.getGiocatoreA().getEroi();
        System.out.print(riga);
        System.out.print(colonna);
        
        Casella c=clash.getGiocatoreD().getVillaggio().getCasella(riga, colonna);
        //manca il controllo se quantità è minore uguale degli eroi disponibili
        for(int i=0;i<eroiA.size() || cont<quantita;i++){
            if(eroiA.get(i).getId()==idEroe){
                cont++;
                c.AddEroe(eroiA.get(i));
            }
            
        }
        if(iniziaBattaglia==1){
           // clash.CambiaStato(st);//esegui stato boh
            //battaglia iniziata
        }
        else{
            ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();
            view.mostraSelezionaPosizionaEroe(eroiA);
        }
    }
    
   
    
}
