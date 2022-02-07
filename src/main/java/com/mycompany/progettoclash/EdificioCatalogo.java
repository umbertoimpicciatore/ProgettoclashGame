
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class EdificioCatalogo {
    private HashMap<Edificio,EdificioDescrizione > descrizioni;
    
    public EdificioCatalogo(){
        descrizioni= new HashMap<>();
        loadEdificiDescrizioni();
    }
    
    public EdificioDescrizione getEdificioDescrizione(Edificio edificio){
        return descrizioni.get(edificio);
    }
    
    
    public ArrayList<EdificioDescrizione> getAllEdificiDescrizioni(){
       return PersistanManager.getInstance().getAllEdificiDescrizioni();
    }
    
    public EdificioDescrizione getDescrizione(int idEdificioDesc){
         return PersistanManager.getInstance().getEdificioDescrizioni(idEdificioDesc);
    }
    
    
    private void loadEdificiDescrizioni(){

        
        
    }
}