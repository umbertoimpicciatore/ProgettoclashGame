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
public class AttaccanoEdifici implements StatoAttacco{

    @Override
    public void esegui(ClashGame clash) {
        
        ArrayList<Casella> listC =  clash.caselleDifensore();
        
        for(int i=0;i<listC.size();i++){
            Edificio ed=listC.get(i).getEdificio();
            ArrayList<Casella> listaCaselleConEroiDaAttaccare=ed.getModA().attaccoEdificio(ed);
            for(int j=0;j<listaCaselleConEroiDaAttaccare.size();j++){
                ArrayList<Eroe> listE= listaCaselleConEroiDaAttaccare.get(j).getListaEroiA();
                for(int k=0;k<listE.size();k++){
                    listE.get(k).stat.setVita(2);
                
            }
            }
            
            
        }
    }
    
}
