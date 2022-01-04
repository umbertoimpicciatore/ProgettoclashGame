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
        
        ArrayList<Casella> listC =  clash.caselleDifensore();//recupero le caselle del difensore
        
        for(int i=0;i<listC.size();i++){//per ogni casella mi recupero l'edificio
            Edificio ed=listC.get(i).getEdificio();
            if(ed!=null){
                ArrayList<Casella> listaCaselleConEroiDaAttaccare=ed.getModA().attaccoEdificio(ed);//recupero la lista delle caselle con gli eroi da attaccare
                for(int j=0;j<listaCaselleConEroiDaAttaccare.size();j++){
                ArrayList<Eroe> listE= listaCaselleConEroiDaAttaccare.get(j).getListaEroiA();
                    for(int k=0;k<listE.size();k++){
                        Eroe eroe=listE.get(k);

                        int vita=eroe.getStat().getVita();//VEDERE SE FARE UNA CLASSE O QUALCOSA PER LA REGOLA DI TOGLIMENTO VITA
                        int difesa=eroe.getStat().getDifesa()+eroe.getSkin().getDifesa();
                        int attaccoEdificio=ed.getStatistica().getAttacco();//+ la attacco della skin?
                        if(attaccoEdificio-difesa>5 &&vita>0){
                            int attdif=attaccoEdificio-difesa;
                            vita-=attdif;
                        }
                        else{
                            vita-=5;
                        }
                        if(vita<0){
                            vita=0;
                        }
                        eroe.setVita(vita);
                
                    }
            }
            }
            
               
        }
        this.cambiaStato(clash,new ControlloFineBattaglia());
    }

    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }
    
    
}
