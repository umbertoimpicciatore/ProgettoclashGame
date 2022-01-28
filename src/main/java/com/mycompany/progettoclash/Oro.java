
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class Oro implements Risorsa {
    
    private String nome="Oro";
    private int quantità;

    Oro(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getQuantita() {
        return this.quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
    
}
