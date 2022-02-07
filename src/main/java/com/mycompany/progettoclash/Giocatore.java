
package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class Giocatore {
    
    private HashMap<EroeDescrizione, Integer > livelloEroi;
    private int livello;
    private Accampamento Accampamento;
    private Accademia Accademia;
    private ArrayList<Deposito> depositiOro;
    private ArrayList<Deposito> depositiMana;
    private String nome;
    private Villaggio villaggio;
    private Municipio municipio;
    
    
    public double mostraOro(){
        double q=0;
        for (int i=0;i<this.depositiOro.size();i++){
            q=q+this.depositiOro.get(i).getRisorsa().getQuantita();
            
        }
        return q;
    }
    public double mostraMana(){
        double q=0;
        for (int i=0;i<this.depositiMana.size();i++){
            q=q+this.depositiMana.get(i).getRisorsa().getQuantita();
            
        }
        return q;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public ArrayList<Deposito> getDepositiOro() {
        return depositiOro;
    }

    public void setDepositiOro(ArrayList<Deposito> depositiOro) {
        this.depositiOro = depositiOro;
    }

    public ArrayList<Deposito> getDepositiMana() {
        return depositiMana;
    }

    public void setDepositiMana(ArrayList<Deposito> depositiMana) {
        this.depositiMana = depositiMana;
    }
    
    
    public HashMap<EroeDescrizione, Integer> getLivelloEroi() {
        return livelloEroi;
    }

    public void setLivelloEroi(HashMap<EroeDescrizione, Integer> livelloEroi) {
        this.livelloEroi = livelloEroi;
    }

    
    public Accademia getAccademia() {
        return Accademia;
    }

    public void setAccademia(Accademia Accademia) {
        this.Accademia = Accademia;
    }


    public Villaggio getVillaggio() {
        return villaggio;
    }

    public Accampamento getAccampamento() {
        return Accampamento;
    }

    public void setAccampamento(Accampamento Accampamento) {
        this.Accampamento = Accampamento;
    }

    
    public void setVillaggio(Villaggio v) {
        this.villaggio = v;
    }
    
    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Eroe> getEroi(){
        return this.Accampamento.getListaEroiGiocatore();
    }
    
    public int getSommaLivelloEroi(){  
        int l=0;
        for (EroeDescrizione key : this.livelloEroi.keySet()){
            l+=this.livelloEroi.get(key);
        }
    return l;
    }
    
    public void rimuoviRisorse(Risorsa risorsa){
        ArrayList<Deposito> depositi=this.depositiOro;
        depositi.addAll(this.depositiMana);
        double quantita=risorsa.getQuantita();
        for(int i=0;i<depositi.size();i++){
            Risorsa r=depositi.get(i).getRisorsa();
            double qDeposito=r.getQuantita();
            if(r.getNome().equals(risorsa.getNome())){
                if((qDeposito-quantita)>=0){
                    r.setQuantita(qDeposito-quantita);
                    return;
                }
                else{
                    r.setQuantita(0);
                    quantita=quantita-qDeposito;
                }
            }
        }
        
    }
    //DA TESTARE
    public boolean controllaRisorsa(Risorsa risorsa){
        ArrayList<Deposito> depositi=this.depositiOro;
        depositi.addAll(this.depositiMana);
        double quantita=risorsa.getQuantita();
        double cont=0;
        for(int i=0;i<depositi.size();i++){
            Risorsa r=depositi.get(i).getRisorsa();
            if(r.getNome().equals(risorsa.getNome())){
                cont=cont +r.getQuantita();
            }
        }
        if(cont>=quantita){
            return true;
        }
        else{
            return false;
        }
    }
    
        
    /*public int quantiDepositi(Risorsa risorsa){
        int c=0;
        for(int i=0;i<this.depositi.size();i++){
            Deposito d=this.depositi.get(i);
            if(d.getRisorsa().getNome().equals(risorsa.getNome())){
                c++;
            }
        }
        return c;
    }*/
    
   
    
}
