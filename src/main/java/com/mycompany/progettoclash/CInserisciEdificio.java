
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
    
    public ArrayList<EdificioDescrizione>  operazione(Giocatore g){
        EdificioCatalogo catalogo=new EdificioCatalogo();
        ArrayList<EdificioDescrizione> desc=catalogo.getAllEdificiDescrizioni();
        return desc;
    }
    
    
    public boolean operazione10(int idEdificioDesc){
        EdificioCatalogo catalogo=new EdificioCatalogo();
        EdificioDescrizione edDesc=catalogo.getDescrizione(idEdificioDesc);
        Risorsa r=edDesc.getPrezzoDiAcquisto();
        boolean b=this.giocatore.getVillaggio().quantitaMassimaEdificioRaggiunto(edDesc);
        boolean b1=this.giocatore.controllaRisorsa(r);
        if(b==false || b1==false){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean operazione11(int riga,int colonna){
        boolean b=this.giocatore.getVillaggio().casellaDisponibile(riga, colonna);
        return b;
    }
    
    public void conferma2(int idEdificioDesc,int riga,int colonna){
        this.giocatore.getMunicipio().inserisci(idEdificioDesc,riga,colonna,this.giocatore);
    
    }
    
 
}
