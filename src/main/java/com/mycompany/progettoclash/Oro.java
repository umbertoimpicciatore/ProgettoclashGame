
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class Oro implements Risorsa, Cloneable{
    
    private String nome="Oro";
    private double quantità;

    public Oro(double a){
    this.quantità=a;
    
    }
    public Oro(){
    this.quantità=0;
    
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
    
    public String toString(){
        String s;
        String s1=" Quantità: "+ this.quantità;
        s=" Risorsa:".concat(this.nome).concat(s1);
        return s;
    }
    
}
