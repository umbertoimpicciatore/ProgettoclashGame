package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Municipio extends Edificio {
    
    AcquistoEroiEdificio desc=new AcquistoEroiEdificio();

    public Municipio(EdificioDescrizione desc){
        super(desc);
    }
    public Municipio(){
        
    }
    
    public AcquistoEroiEdificio getDesc() {
        return desc;
    }

    public void setDesc(AcquistoEroiEdificio desc) {
        this.desc = desc;
    }

    @Override
    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
    }
    
    public void inserisci(Giocatore g){
            EdificioDescrizione desc=this.desc.getEdificioDescrizione();
            System.out.println(desc.toString());
            int riga=this.desc.getRiga();
            int colonna=this.desc.getColonna();
            Edificio edificio=CreaEdificioFactory.getInstance().getEdificio(desc,g);
            Risorsa r=desc.getPrezzoDiAcquisto();
            g.rimuoviRisorse(r);
            
            g.getVillaggio().setEdificioSuCasella(riga, colonna, edificio);
            //Casella c=v.getCasella(riga, colonna);
           // c.setEdificio(edificio);
           // edificio.setCasella(c);
            
    }
}
