package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;

/**
 *
 * @author Lorenzo
 */
public class BattagliaPersistant {
    
    private static BattagliaPersistant instance = null; 
    private BattagliaPersistant() {} 
 
    public static BattagliaPersistant getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new BattagliaPersistant();
        }
        return instance;
    }
    
    public Battaglia getBattaglia(int idBattaglia){
        Battaglia b=PersistanManager.getInstance().getBattaglia(idBattaglia);
        return b;
    }
    
    public int getUltimoId(){
        int id=PersistanManager.getInstance().getUltimoIdBattaglia();
        return id;
    }
    public void setBattaglia(Battaglia b){
        PersistanManager.getInstance().setBattaglia(b);
    }
    
    public void setUltimoId(int id){
        PersistanManager.getInstance().setUltimoIdBattaglia(id);
    }
}
