package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AttaccaTorre implements ModalitàAttacco {

     @Override
    public ArrayList<Casella> attacco(Eroe e){                
        return new ArrayList<Casella>();
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        Villaggio villaggioD=e.getCasella().getVillaggio();
        return villaggioD.getCaselle();              
        }

    @Override
    public ArrayList<Casella> caselleBersaglio(Casella c) {
        ArrayList<Casella> caselle=c.getVillaggio().getCaselle();
        return caselle;
    }
        
    }
