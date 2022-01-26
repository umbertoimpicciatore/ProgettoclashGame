/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewCercaAvversario;
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
    
    public SelezionePosizionaEroe(){
    }
    
    public SelezionePosizionaEroe(ClashGame clash){
        
    this.clash=clash;
    
    }
    
    public void selezionaPosizionaEroe(int riga,int colonna,int idEroe,int quantita,int iniziaBattaglia,Giocatore giocatoreA,Giocatore giocatoreD) {
        
        ViewCercaAvversario view=new ViewCercaAvversario();
        ClashGame clash=new ClashGame(giocatoreA,giocatoreD);
        //RIGUARDA ATTENTAMENTO PER IL NULL
        ArrayList<Eroe> eroiA=giocatoreA.getAccampamento().selezionaEroe(idEroe, quantita);
        if(eroiA==null){
            //in caso di errori rifaccio fare la selezione posizione eroe
            view.mostraSelezionaPosizionaEroe(giocatoreA, giocatoreD, true);
            
        }
        else{
            
            clash.posizionaEroe(riga, colonna, eroiA);
            view.iniziaBattaglia(clash);
        }
       
        /*
        if(iniziaBattaglia==1){
            clash.iniziaBattaglia();//simulazione battaglia
           
        }
        else{
            ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();
            view.mostraSelezionaPosizionaEroe(giocatoreA.getEroi());
        }*/
       /* int cont=0;
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
            //ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();
            //view.mostraSelezionaPosizionaEroe(eroiA);
        }
        
        */
        
        
    }
    
   
    
}
