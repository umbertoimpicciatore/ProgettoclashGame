
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
    
    public void setVita(int vita){
        this.statistica.setVita(vita);
    
    }
    public Casella getC() {
        return casella;
    }

    public void setC(Casella c) {
        this.casella = c;
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
