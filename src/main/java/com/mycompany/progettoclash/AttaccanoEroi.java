
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class AttaccanoEroi implements StatoAttacco{

    @Override
    public void esegui(ClashGame clash) {
        
        ArrayList<Casella> listC =  clash.caselleDifensore();
        
        for(int i=0;i<listC.size();i++){
           
            ArrayList<Eroe> eroi=listC.get(i).getListaEroiA();
            for(int j=0;j<eroi.size();j++){
                Eroe e=eroi.get(j);
                ArrayList<Casella> listCaselleDaAttaccare=e.getModA().attacco(e);
                //attacca
            }
            
        }

    }

    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }
    
    
}
