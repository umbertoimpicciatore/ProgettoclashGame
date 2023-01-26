package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Lorenzo
 */
public class Accampamento extends Edificio {
    
    private AcquistoEroiEdificio acquisto;
    private Giocatore giocatore;

    
    private ArrayList<Eroe> listaEroiGiocatore = new ArrayList<Eroe>();

    
    public ArrayList<Eroe> getListaEroiGiocatore() {
        return listaEroiGiocatore;
    }

    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
        this.listaEroiGiocatore = listaEroiGiocatore;
    }
    
    public Accampamento(EdificioDescrizione desc){
        super(desc);
    }
    public Accampamento(){
        
    }
    
    public ArrayList<Eroe> selezionaEroe(int idEroe,int quantita){
        ArrayList<Eroe> listaEroi = new ArrayList<Eroe>();
        boolean var=this.controllaQuantitaIdEroe(idEroe, quantita);
        if(var==true){
            int cont=0;
            int i=0;
            while(i<this.listaEroiGiocatore.size() && cont<quantita){
                if(this.listaEroiGiocatore.get(i).getEroeDescrizione().getIdDesc()==idEroe){
                    cont++;
                    listaEroi.add(this.listaEroiGiocatore.get(i));
                    this.listaEroiGiocatore.remove(i);
                }
                else{
                    i++;
                }             
            }
            return listaEroi;
        }
        else{
            return null;
        }
    }
    
    public boolean controllaQuantitaIdEroe(int idEroe,int quantita){
        int cont=0;
        boolean idEroeTrovato=false;
        for(int i=0;i<this.listaEroiGiocatore.size();i++){
            if(this.listaEroiGiocatore.get(i).getEroeDescrizione().getIdDesc()==idEroe){
            idEroeTrovato=true;
                cont++;
                if(cont==quantita){
                    return true;
                }
            }
        }
        if(cont==quantita && idEroeTrovato==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public AcquistoEroiEdificio getAcquisto() {
        return acquisto;
    }

    public void setAcquisto(AcquistoEroiEdificio acquisto) {
        this.acquisto = acquisto;
    }
    
    public void acquistaEroi(){

        CreaEroeStrategy strategyEroe = CreaEroeFactory.getInstance().getStrategy(); 
        strategyEroe.creaEroe(this);//cambia NOME METODO      
        Risorsa prezzoAcquisto=acquisto.getEroeDescrizione().getPrezzoDiAcquisto();
        int quantita=acquisto.getQuantita();
        double quantitaAcquisto=prezzoAcquisto.getQuantita();
        double q=quantitaAcquisto*quantita;
        prezzoAcquisto.setQuantita(q);
        giocatore.rimuoviRisorse(prezzoAcquisto);
        prezzoAcquisto.setQuantita(quantitaAcquisto);
        
    }
    
    public void addEroi(ArrayList<Eroe> eroi){
        for(int i=0;i<eroi.size();i++){
            this.listaEroiGiocatore.add(eroi.get(i));
        }    
    }
    
        //rimuove gli eroi con la descrizione idEroeDescrizione e restituisce la quantita rimossa
    public int removeEroe(EroeDescrizione desc){
        int quantita=0;
        ArrayList<Eroe> listaEroi=this.listaEroiGiocatore;
        int i=0;
        while(i<listaEroi.size()){
            if(desc==listaEroi.get(i).getEroeDescrizione()){               
                quantita++;
                listaEroi.remove(i);
            }
            else{
                i++;
            }
        }
        return quantita;     
    }
    
    //RICONTROLLA
    //metodo per mostrare eroeDEscrizione e la quantita di eroe disponibile
    public HashMap<EroeDescrizione,Integer> mostraEroiDescQuantita(){
        HashMap<EroeDescrizione,Integer> map=new HashMap<EroeDescrizione,Integer>();
        ArrayList<Integer> idEroi=new ArrayList<Integer>();
        for(int i=0;i<this.listaEroiGiocatore.size();i++){
            Eroe e=this.listaEroiGiocatore.get(i);
            EroeDescrizione desc=e.getEroeDescrizione();
            int idDesc=e.getEroeDescrizione().getIdDesc();
            boolean b=idEroi.contains(idDesc);
            if(b){
                int quantita=map.get(desc);
                map.put(e.getEroeDescrizione(), quantita+1);
            }
            else{
                idEroi.add(idDesc);
                map.put(desc, 1);
            }
        }
        return map;
    }
    


    public Giocatore getGiocatore() {
        return giocatore;
    }

    public void setGiocatore(Giocatore giocatore) {
        this.giocatore = giocatore;
    }

    
 
}
