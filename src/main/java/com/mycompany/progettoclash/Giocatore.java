
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
    private Accampamento Accampamento;//vedere LARMAN
    private Accademia Accademia;//VALUTARE BENE SE METTERLO OPPURE NO, RILEGGI IL LARMAN
    private Deposito deposito;
    private String nome;
    private Villaggio villaggio;
    
    
    
    
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
    

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
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
    
   /* public void posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        Casella c=clash.getGiocatoreD().getVillaggio().getCasella(riga, colonna);
        c.addEroi(listaEroi);
        
    }*/
    
  /*  public void cercaAvversario(){
        
        TrovaAvversario t=new TrovaAvversario();
        Giocatore giocatoreD=t.getAvversario(this);
        ViewCercaAvversario view=new ViewCercaAvversario();//si può fare dentro il controller?
        view.conferma(giocatoreD,this); 
    }
    */
    
    
}
