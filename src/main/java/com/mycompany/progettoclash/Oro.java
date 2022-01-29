
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class Oro implements Risorsa {
    
    private String nome="Oro";
    private double quantità;

    public Oro(double a){
    this.quantità=a;
    
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public  double getQuantita() {
        return this.quantità;
    }

    public void setQuantita(double quantità) {
        this.quantità = quantità;
    }
    
}
