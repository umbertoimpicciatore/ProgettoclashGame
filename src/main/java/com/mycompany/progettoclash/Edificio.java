
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public abstract class Edificio {
    private int id;
    private Casella casella;
    private Statistica statistica;
    private EdificioDescrizione edificioDescrizione;

    public EdificioDescrizione getEdificioDescrizione() {
        return edificioDescrizione;
    }

    public void setEdificioDescrizione(EdificioDescrizione edificioDescrizione) {
        this.edificioDescrizione = edificioDescrizione;
    }

    public abstract void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore); //l'ho messo per l'accampamento

    public Edificio(){
        this.id=PersistanManager.getInstance().getidEdificio()+1;
        PersistanManager.getInstance().setUltimoIdEdificio(this.id);
    }

    public Edificio(EdificioDescrizione desc){
        this.edificioDescrizione=desc;
        int vita=this.edificioDescrizione.getStatistica().getVita();
        int difesa=this.edificioDescrizione.getStatistica().getDifesa();
        int attacco=this.edificioDescrizione.getStatistica().getAttacco();        
        this.statistica=new Statistica(difesa,attacco,vita);
        this.id=PersistanManager.getInstance().getidEdificio()+1;
        PersistanManager.getInstance().setUltimoIdEdificio(this.id);
    }
    
     public Casella getCasella() {
        return casella;
    }

    public void setCasella(Casella casella) {
        this.casella = casella;
    }
    public void setVita(int vita){
        this.statistica.setVita(vita);
    
    }
            
    public Statistica getStatistica() {        
         return this.statistica;
    }
    
    public int getVita() {        
         return this.statistica.getVita();
    }

    public void setStatistica(Statistica statistica) {
        this.statistica=statistica;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ModalitàAttacco getModalitaAttacco(){
        return this.edificioDescrizione.getModalitaAttacco();
    }


    
}
