
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
    private ArrayList<Deposito> depositi;
    private String nome;
    private Villaggio villaggio;
    
    
    public void rimuoviRisorse(Risorsa risorsa){
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
    
    public boolean controllaRisorsa(Risorsa risorsa){
    
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

    public ArrayList<Deposito> getDepositi() {
        return depositi;
    }

    public void setDepositi(ArrayList<Deposito> depositi) {
        this.depositi = depositi;
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
