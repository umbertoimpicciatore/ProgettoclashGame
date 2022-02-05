package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class Accampamento extends Edificio {
    
    private ArrayList<Eroe> listaEroiGiocatore = new ArrayList<Eroe>();

    public ArrayList<Eroe> getListaEroiGiocatore() {
        return listaEroiGiocatore;
    }

    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
        this.listaEroiGiocatore = listaEroiGiocatore;
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
           /* if(this.listaEroiGiocatore.get(i).getId()==idEroe){
                idEroeTrovato=true;
                cont++;
                if(cont==quantita){
                    return true;
                }
            }    */
        }
        if(cont==quantita && idEroeTrovato==true){
            return true;
            
        }
        else{
            return false;
        }
    }
    
    
    public void acquistaEroi(int idEroeDescrizione,int quantita,Giocatore giocatore){
        EroeCatalogo edC=new EroeCatalogo();
        EroeDescrizione desc=null;
        for (EroeDescrizione name: giocatore.getLivelloEroi().keySet()) {//controllare bene questo
             if(name.getIdDesc()==idEroeDescrizione){
                 desc=name;
             }
        }
        //EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        CreaEroeStrategy strategyEroe=null;
        try {
            strategyEroe = CreaEroeFactory.getInstance().getStrategy();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Accademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        strategyEroe.creaEroe(desc,quantita,giocatore);//cambia NOME METODO
        Risorsa prezzoAcquisto=desc.getPrezzoDiAcquisto();
        double q=prezzoAcquisto.getQuantita()*quantita;
        prezzoAcquisto.setQuantita(q);
        giocatore.rimuoviRisorse(prezzoAcquisto);
        
    }
    
    public void addEroi(ArrayList<Eroe> eroi){
        for(int i=0;i<eroi.size();i++){
            this.listaEroiGiocatore.add(eroi.get(i));
        }
    
    }
    
        //rimuove gli eroi con la descrizione idEroeDescrizione e restituisce la quantita rimossa
    public int removeEroe(int idEroeDescrizione,Giocatore giocatore){
        int quantita=0;
        ArrayList<Eroe> listaEroi=giocatore.getEroi();
        int i=0;
        while(i<listaEroi.size()){
            if(idEroeDescrizione==listaEroi.get(i).getEroeDescrizione().getIdDesc()){               
                quantita++;
                listaEroi.remove(i);
            }
            else{
                i++;
            }
        }
        return quantita;     
    }
    
    
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

    
 
}
