
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

    
    public boolean posizioneEore(int riga,int colonna,ArrayList<Eroe> listaEroi){
        if(riga>this.getAltezza() || colonna>this.getLarghezza()){
            return false;
        }
        else{
            Casella c=this.getCasella(riga, colonna);    
            for(int i=0;i<listaEroi.size();i++){//assegno a ciascun eroe la casella in cui verrà posizionato
                listaEroi.get(i).setC(c);
            }
            c.addEroi(listaEroi);
            return true;
        }
    }
    
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
    
    public void addRisorse(ArrayList<Risorsa> risorse){//addRisorse
        for(int i=0;i<this.caselle.size();i++){
            Edificio e=caselle.get(i).getEdificio();
            if(e!=null && e instanceof Deposito){
                  Deposito d=(Deposito) e;
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
    }
    
    public void perdiRisorse(){
        ArrayList<Casella>  c=this.caselle;
        for(int i=0;i<c.size();i++){
            Casella casella=c.get(i);
            Edificio edificio=casella.getEdificio();
            if(edificio!=null && edificio instanceof Deposito){
                Deposito deposito=(Deposito) edificio;
                Risorsa r=deposito.getRisorsa();
                int vita=deposito.getStatistica().getVita();
                int vitaMassima=deposito.getEdificioDescrizione().getVitaMassima();
                double x=((vitaMassima-vita)*30)/vitaMassima;
                double q2=x/100*r.getQuantita();
                deposito.perdiRisorsa(q2);
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
        
    
    public boolean casellaDisponibile(int riga,int colonna){
        if(riga>this.altezza || colonna>this.larghezza){
            return false;
        }
        else{
            Casella c=this.getCasella(riga, colonna);
            if(c.getEdificio()==null){
                return true;
            }
            else{
                return false;
            }
        }
        
    }   
    
    public boolean quantitaMassimaEdificioRaggiunto(EdificioDescrizione desc){
        int quantitaMassima=desc.getQuantitaMassima();
        int cont=0;
        for(int i=0;i<this.caselle.size();i++){
            Edificio e=this.caselle.get(i).getEdificio();
            if(e!=null){
                if(e.getEdificioDescrizione().getIdDescrizione()==desc.getIdDescrizione()){
                    cont++;
                }
            }
        }
        if(cont==quantitaMassima){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setEdificioSuCasella(int riga,int colonna,Edificio edificio){
        Casella c=this.getCasella(riga, colonna);
        c.setEdificio(edificio);
        edificio.setCasella(c);
    }
        
    
}
    
