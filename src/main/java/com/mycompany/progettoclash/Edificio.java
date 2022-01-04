
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class Edificio {
    private int id;
    private ModalitàAttacco modA;
    private RuoloEdificio ruoloE;
    private Statistica statistica;
    private Casella casella;

   

    
   

    public Edificio(RuoloEdificio re,ModalitàAttacco ma){
        this.modA=ma;
        this.ruoloE=re;
    
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
        return statistica;
    }

    public void setStatistica(Statistica statistica) {
        this.statistica = statistica;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModalitàAttacco getModA() {
        return modA;
    }

    public RuoloEdificio getRuoloE() {
        return ruoloE;
    }
    
    
    
}
