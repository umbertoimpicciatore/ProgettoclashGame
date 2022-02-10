package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ControlloFineBattaglia implements StatoAttacco{

    @Override
    public boolean controlloFineBattaglia(Battaglia battaglia) {
        
        boolean edificiMorti=true;
        boolean eroiMorti=true;       
        ArrayList<Casella> caselle=battaglia.caselleDifensore();
        for (int i=0;i<caselle.size();i++){
            Casella c=caselle.get(i);
            Edificio edificio=c.getEdificio();
            if(edificio!=null){
                if(c.getEdificio().getStatistica().getVita()>0){//controllo se la vita degli edifici è uguale a 0
                    edificiMorti=false;
                }
            }
            if(c.getListaEroiA().size()>0){//controllo se gli eroi sono morti tutti
                eroiMorti=false;
            }
        }
        if(edificiMorti==true || eroiMorti==true){
            return true;
        }
        else{
            this.cambiaStato(battaglia,new Attacco());
            return false;
        }
        
    }
    
    @Override
    public void cambiaStato(Battaglia battaglia, StatoAttacco st) {
        battaglia.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(Battaglia battaglia) {
        
    }

    @Override
    public void attaccanoEroi(Battaglia battaglia) {
    }

    @Override
    public void spostaEroi(Battaglia battaglia) {
    }
    
}
