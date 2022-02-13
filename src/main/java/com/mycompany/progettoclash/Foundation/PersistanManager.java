package com.mycompany.progettoclash.Foundation;

import com.mycompany.progettoclash.Battaglia;
import com.mycompany.progettoclash.EdificioDescrizione;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class PersistanManager {
    
    private static PersistanManager instance = null; 
    private PersistanManager() {} 
 
    public static PersistanManager getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new PersistanManager();
        }
        return instance;
    }
    
    public ArrayList<EroeDescrizione> getAllDescrizioni(){
        Descrizioni d=new Descrizioni();
        return d.getAllDescrizioni();
    }
    
    public EroeDescrizione getEroeDescrizione(int idEroeDesc){
        Descrizioni d=new Descrizioni();
        return d.getEroeDescrizione(idEroeDesc);
    }
    
    public EdificioDescrizione getEdificioDescrizioni(int idEdifDesc){
        Descrizioni d=new Descrizioni();
        return d.getEdificoDescrizione(idEdifDesc);

    }
    
    public ArrayList<EdificioDescrizione> getAllEdificiDescrizioni(){
        Descrizioni d=new Descrizioni();
        return d.getAllEdifDescrizioni();
    }
    
    public EroeDescrizione getArciere(){
        return Descrizioni.getArciere();
    }
    
    public EroeDescrizione getGuerriero(){
        return Descrizioni.getGuerriero();
    }
    
    public EroeDescrizione getRegina(){
        return Descrizioni.getRegina();
    }
         
    public Battaglia getBattaglia(int idBattaglia){
        return  BattagliaF.b;
    }
    
    public int getUltimoIdBattaglia(){
        return  BattagliaF.ultimoId;
    }
    
    public void setBattaglia(Battaglia batt){
        BattagliaF.b=batt;
    }
    
    public void setUltimoIdBattaglia(int id){
          BattagliaF.ultimoId=id;
    }
    
    public ArrayList<Giocatore> getGiocatori(){
          return GiocatoreF.list;
    }
  
    
    
}
