
package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class Giocatore {
    
    private HashMap<EroeDescrizione, Integer > livelloEroi;
    private Accampamento Accampamento;
    private Accademia Accademia;
    private ArrayList<Deposito> depositi;
    private String nome;
    private Villaggio villaggio;
    private Municipio municipio;
    private MatchMakingStrategy strategy;
    
    public ArrayList<Deposito> getDepositi() {
        return depositi;
    }

    public void setDepositi(ArrayList<Deposito> depositi) {
        this.depositi = depositi;
    }
    public void aumentaLivelloEroe(EroeDescrizione desc){
        int livello=this.getLivelloEroi().get(desc);
        this.getLivelloEroi().put(desc, livello+1);
    }
    
    public HashMap<String,Double> mostraRisorse(){
        HashMap<String,Double> map= new HashMap<String,Double>();        
        double q=0;
        for (int i=0;i<this.depositi.size();i++){
            q=0;
            String nome=this.depositi.get(i).getRisorsa().getNome();
            q=q+this.depositi.get(i).getRisorsa().getQuantita();
            if(map.containsKey(nome)){
                double quantitaCorrente=map.get(nome);
                map.put(nome, quantitaCorrente+q);
            }
            else{
                map.put(nome, q);
            }
        }
        return map;
    }
    
     public Giocatore cercaAvversario(){
         if(strategy==null){
             strategy=MatchMakingFactory.getInstance().getStrategy();
         }
         
        //MatchMakingStrategy strategy=MatchMakingFactory.getInstance().getStrategy();
        return strategy.getAvversario(this);       
    }

    
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
        double quantita=risorsa.getQuantita();
        for(int i=0;i<this.depositi.size();i++){
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

    public void addRisorse(ArrayList<Risorsa> risorse){//addRisorse
        for(int i=0;i<this.depositi.size();i++){
            Deposito d=depositi.get(i);
                  Risorsa r=d.getRisorsa();//risorsa deposito
                  int ris=isInArray(r,risorse);
                  if(ris>=0){
                        Risorsa risorsaCorrente=risorse.get(ris);
                        risorsaCorrente=d.addRisorsa(risorsaCorrente);
                        if(risorsaCorrente.getQuantita()==0){
                            risorse.remove(ris);
                        }
                  }

        }            
    }
    private int isInArray(Risorsa r,ArrayList<Risorsa> list){
        if(list!=null){
            for(int i=0;i<list.size();i++){
                    if(list.get(i).getNome().equals(r.getNome())){
                        return i;
                    }
                }
            }
            return -1;
    }    
}
