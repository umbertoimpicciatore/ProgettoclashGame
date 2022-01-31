
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Villaggio {
    
    private int larghezza=4;
    private int altezza=4;
    private ArrayList<Casella> caselle = new ArrayList<Casella>();

    public ArrayList<Casella> getCaselle() {
        return caselle;
    }
    private int danni;

    public int getDanni() {
        return danni;
    }

    public void setDanni(int danni) {
        this.danni = danni;
    }
    
   /* public Edificio cercaAccampamento(){
        Edificio e;
        for(int i=0;i<caselle.size();i++){
            e.getCasella().getEdificio().
        }
    
    }*/

    public void setCaselle(ArrayList<Casella> cars) {
        this.caselle = cars;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
    
    public Casella getCasella(int riga,int col){
        Casella c;
        for(int i=0;i<caselle.size();i++){
            c=caselle.get(i);
            if(c.getPosizioneRiga()==riga && c.getPosizioneColonna()==col){
                 return c;
               
            }
        }
        return null; 
    }
    
    public void setCasella(Casella c){
        Casella c2;
        for(int i=0;i<caselle.size();i++){
            c2=caselle.get(i);
            if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                caselle.set(i, c);
            }
        }
    }
    
    public void addRisorse(ArrayList<Risorsa> risorse){
        for(int i=0;i<this.caselle.size();i++){
            Edificio e=caselle.get(i).getEdificio();
            if(e!=null && e instanceof Deposito){
                  Deposito d=(Deposito) e;
                  Risorsa r=d.getRisorsa();//risorsa deposito
                  int ris=isInArray(r,risorse);
                  if(ris>0){
                      Risorsa risorsaCorrente=risorse.get(ris);
                      double quantita=risorsaCorrente.getQuantita();//quantita da aggiungere
                      double qDeposito=r.getQuantita();//quantita deposito
                      double quantitaMassima=d.getEdificioDescrizione().getQuantitaMassima();
                      if(qDeposito<quantitaMassima){
                          qDeposito+=quantita;
                          quantita=0;
                          if(qDeposito>quantitaMassima){//se vai oltre la capacita
                              quantita=qDeposito-quantitaMassima;
                              qDeposito-=quantita;
                              risorsaCorrente.setQuantita(quantita);
                              risorse.set(ris, risorsaCorrente);
                          }
                          else{
                              risorse.remove(ris);
                          }  
                          r.setQuantita(qDeposito);
                          d.setRisorsa(r);
                      }
                  }
            }
        }            
    }
    
    public void perdiRisorse(){
        ArrayList<Casella>  c=this.caselle;
        for(int i=0;i<c.size();i++){
            Casella casella=c.get(i);
            Edificio edificio=casella.getEdificio();
            if(edificio!=null && edificio.getEdificioDescrizione().getNome().equals("Deposito")){
                Deposito deposito=(Deposito) edificio;
                Risorsa r=deposito.getRisorsa();
                int vita=deposito.getStatistica().getVita();
                int vitaMassima=deposito.getEdificioDescrizione().getVitaMassima();
                double q=(vitaMassima-vita)*30/100;
                double quantita=r.getQuantita()-q;
                if(quantita<0){
                    r.setQuantita(0);
                }
                else{
                    r.setQuantita(quantita);
                }
            }   
        }
    }
        

        private int isInArray(Risorsa r,ArrayList<Risorsa> list){
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNome().equals(r.getNome())){
                    return i;
                }
            }
            return -1;
        }
    
    }
    
