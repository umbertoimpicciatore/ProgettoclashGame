
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Giocatore {
    private String nome;
    private Villaggio villaggio;

    public Villaggio getVillaggio() {
        return villaggio;
    }

    public void setVillaggio(Villaggio v) {
        this.villaggio = v;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Eroe> getEroi(){
        return new ArrayList<Eroe>();//da implementare
    }
    
    
}
