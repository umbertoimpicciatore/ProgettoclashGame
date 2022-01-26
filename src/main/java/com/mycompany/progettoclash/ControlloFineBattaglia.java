/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ControlloFineBattaglia implements StatoAttacco{

    @Override
    public void esegui(ClashGame clash) {
        
        boolean edificiMorti=true;
        boolean eroiMorti=true;
        
        ArrayList<Casella> caselle=clash.getGiocatoreD().getVillaggio().getCaselle();
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
        //richiama factory ottenimento risorse
        }
        else{
            this.cambiaStato(clash,new AttaccanoEroi());
            
        }
        
        //da implementare
        System.out.println("Fine battaglia");
    }

    
    
    
    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(ClashGame clash) {
        
    }
    
}
