
package com.mycompany.progettoclash;

import java.util.ArrayList;


/**
 *
 * @author Lorenzo
 */
public class CInserisciEdificio {
    
    private Giocatore giocatore;

    public CInserisciEdificio(Giocatore g) {
        this.giocatore = g;
    }
    
    public ArrayList<EdificioDescrizione>  operazione(){
        EdificioCatalogo catalogo=new EdificioCatalogo();
        ArrayList<EdificioDescrizione> desc=catalogo.getAllEdificiDescrizioni();
        return desc;
    }
    
    
    public boolean operazione10(int idEdificioDesc){
        EdificioCatalogo catalogo=new EdificioCatalogo();
        EdificioDescrizione edDesc=catalogo.getDescrizione(idEdificioDesc);
        this.giocatore.getMunicipio().setDesc(new AcquistoEroiEdificio(edDesc));
        if(edDesc==null){
            return false;
        }
        else{
            Risorsa r=edDesc.getPrezzoDiAcquisto();
            boolean b=this.giocatore.getVillaggio().quantitaMassimaEdificioRaggiunto(edDesc);
            boolean b1=this.giocatore.controllaRisorsa(r);
            if(b==true || b1==false){
                return false;
            }
            else{
                return true;
            }
        }
        
    }
    
    public boolean operazione11(int riga,int colonna){
        this.giocatore.getMunicipio().getDesc().setColonna(colonna);
        this.giocatore.getMunicipio().getDesc().setRiga(riga);
        boolean b=this.giocatore.getVillaggio().casellaDisponibile(riga, colonna);
        return b;
    }
    
    public void conferma2(){
        this.giocatore.getMunicipio().inserisci(this.giocatore);
    
    }
    
 
}
