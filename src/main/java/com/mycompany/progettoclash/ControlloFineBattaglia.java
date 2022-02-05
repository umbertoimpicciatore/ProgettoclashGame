package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ControlloFineBattaglia implements StatoAttacco{

    @Override
    public boolean controlloFineBattaglia(ClashGame clash) {
        
        boolean edificiMorti=true;
        boolean eroiMorti=true;       
        ArrayList<Casella> caselle=clash.caselleDifensore();
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
            this.cambiaStato(clash,new Attacco());
            return false;
        }
        
    }
    
    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(ClashGame clash) {
        
    }

    @Override
    public void attaccanoEroi(ClashGame clash) {
    }

    @Override
    public void spostaEroi(ClashGame clash) {
    }
    
}
