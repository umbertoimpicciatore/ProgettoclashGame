
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class AttaccaAvanti implements ModalitàAttacco {
    @Override
    public ArrayList<Casella> attacco(Eroe e){                
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        return g;
        
        
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getCasella());
        return g;
    }

    @Override
    public ArrayList<Casella> caselleBersaglio(Casella c) {
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(c);
        return g;
    }
    
}
