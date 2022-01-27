
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class SpostaEroe implements StatoAttacco{

    @Override
    public boolean controlloFineBattaglia(ClashGame clash) {
    
        ArrayList<Casella> listC =  clash.caselleDifensore(); //recupero le caselle del difensore
        for(int i=0;i<listC.size();i++){
            Casella casellaCorrente=listC.get(i);
            if(casellaCorrente.getEdificio().getStatistica().getVita()==0){
                Casella casella=this.spostamentoEroi(clash.getGiocatoreD().getVillaggio(), casellaCorrente);
                ArrayList<Eroe> eroi=listC.get(i).getListaEroiA();//recupero  gli eroi del giocatore attaccante sulla caselle del difensore
 
                for(int j=0;j<eroi.size();j++){
                    Eroe e=eroi.get(j);//recupero l'eroe
                    casella.AddEroe(e);//lo aggiungo alla nuova casella        
                }
            casellaCorrente.setListaEroiA(new ArrayList<Eroe>());

            }
            
        }
        return false;
    }

    //metodo utilizzato per spostare gli eroi verso la prossima casella da attaccare
    private Casella spostamentoEroi(Villaggio v,Casella c){
        int riga=c.getPosizioneRiga();
        int colonna=c.getPosizioneColonna();
        int cont=0;
        for(int i=riga-1 ;cont<3 && i>1 && i<v.getAltezza();i++){            
            int cont2=0;
            for(int j=colonna-1;cont2<3 &&j>1 &&j>v.getLarghezza();j++){
                Casella c2=v.getCasella(i, j);
                int vita=c2.getEdificio().getStatistica().getVita();
                if(vita>0){ 
                    return c2;
                }
                cont2++;
            }
            cont++;        
        }
        
        
        /*for(int i=0;i<3;i++){
            prossimaColonna+=i;
            if(prossimaRiga>1 && prossimaRiga<v.getAltezza() && prossimaColonna>1 && prossimaColonna<v.getLarghezza()){
                Casella c2=v.getCasella(riga, prossimaColonna);
                int vita=c2.getEdificio().getStatistica().getVita();
                if(vita>0){
                    risultato=c2;
                    return risultato;
                }
        }
        }
        
        for(int i=0;i<3;i=i+2){
            prossimaColonna+=i;
            if(prossimaRiga>1 && prossimaRiga<v.getAltezza() && prossimaColonna>1 && prossimaColonna<v.getLarghezza()){
                Casella c2=v.getCasella(riga, prossimaColonna);
                int vita=c2.getEdificio().getStatistica().getVita();
                if(vita>0){
                    risultato=c2;
                    return risultato;
                }
        }
        }            
        
        for(int i=0;i<3;i=i){
            prossimaColonna+=i;
            if(prossimaRiga>1 && prossimaRiga<v.getAltezza() && prossimaColonna>1 && prossimaColonna<v.getLarghezza()){
                Casella c2=v.getCasella(riga, prossimaColonna);
                int vita=c2.getEdificio().getStatistica().getVita();
                if(vita>0){
                    risultato=c2;
                    return risultato;
                }
        }
        }
        
        */
        Casella c2=this.cercaCasellaVersoCuiSpostarsi(v, c);      
        return c2;
    
    }
    
    //metodo per spostarsi verso la prima casella che si trova con la vita dell'edificio >0 
    private Casella cercaCasellaVersoCuiSpostarsi(Villaggio v,Casella c){ //45 righe ATTENZIONE VEDERE
        int prossimaRiga=0;
        int prossimaColonna=0;
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c2=v.getCasella(i, j);
                    int vita=c2.getEdificio().getStatistica().getVita();
                    if(vita>0){
                        if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()<c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()==c.getPosizioneRiga() && c2.getPosizioneColonna()>c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()>c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()<c.getPosizioneRiga() && c2.getPosizioneColonna()==c.getPosizioneColonna()){
                            prossimaRiga=c.getPosizioneRiga();
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()-1;
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()<c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()-1;
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()<c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()+1;
                            prossimaColonna=c.getPosizioneColonna()-1;
                        }
                        else if(c2.getPosizioneRiga()!=c.getPosizioneRiga() && c2.getPosizioneColonna()!=c.getPosizioneColonna() && c2.getPosizioneColonna()>c.getPosizioneColonna() && c2.getPosizioneRiga()>c.getPosizioneRiga()){
                            prossimaRiga=c.getPosizioneRiga()+1;
                            prossimaColonna=c.getPosizioneColonna()+1;
                        }
                        return v.getCasella(prossimaRiga,prossimaColonna);
                    }
            }
        }
        return null;
        }
    
    
    
    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(ClashGame clash) {
        //
    }

    @Override
    public void attaccanoEroi(ClashGame clash) {
    }
    
    
}
