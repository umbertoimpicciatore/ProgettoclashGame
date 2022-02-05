package com.mycompany.progettoclash.Foundation;

import com.mycompany.progettoclash.EdificioDescrizione;
import com.mycompany.progettoclash.EroeDescrizione;
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
         
    
  
    
    
}
