
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class Edificio {
    private int id;
    private ModalitàAttacco modA;
    private RuoloEdificio ruoloE;

    public Edificio(RuoloEdificio re,ModalitàAttacco ma){
        this.modA=ma;
        this.ruoloE=re;
    
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
