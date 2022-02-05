package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Municipio extends Edificio {
    


    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    public void inserisci(int idEdifDescrizione,int riga,int colonna,Giocatore g){
       
            EdificioCatalogo catalogo=new EdificioCatalogo();
            EdificioDescrizione desc=catalogo.getDescrizione(idEdifDescrizione);
            Edificio edificio=CreaEdificioFactory.getInstance().getEdificio(desc);
            Risorsa r=desc.getPrezzoDiAcquisto();
            g.rimuoviRisorse(r);
            Villaggio v=g.getVillaggio();
            Casella c=v.getCasella(riga, colonna);
            c.setEdificio(edificio);
            edificio.setCasella(c);

        
    }
}
