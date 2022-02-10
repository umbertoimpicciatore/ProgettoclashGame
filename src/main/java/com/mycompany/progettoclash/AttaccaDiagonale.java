
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class AttaccaDiagonale implements ModalitàAttacco{

    @Override
    public ArrayList<Casella> attacco(Eroe e) {
        ArrayList<Casella> g=new ArrayList<Casella>();
        Villaggio villaggioD=e.getC().getVillaggio();
        g.add(e.getC());
        int col=e.getC().getPosizioneColonna();
        int riga=e.getC().getPosizioneRiga();
        int cont=col;
        for(int i=riga;i>1  && cont<=altezza && cont>1;i--){
            Casella c=villaggioD.getCasella(i-1, cont-1);
            cont--;
            g.add(c);
        }
        cont=col;
        for(int i=riga;i<altezza && cont<lunghezza;i++){
            Casella c=new Casella(cont+1,i+1);
            cont++;
            g.add(c);
        }
        //for per DEBUG
       /* for(int j=0;j<g.size();j++){
            System.out.println("Riga: "+g.get(j).getPosizioneRiga());
            System.out.println("Colonna: "+g.get(j).getPosizioneColonna());
            System.out.println();
        }*/
        
        return g;
    }

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }

    @Override
    public ArrayList<Casella> caselleBersaglio(Casella c) {
        ArrayList<Casella> g=new ArrayList<Casella>();
        Villaggio villaggioD=c.getVillaggio();
        g.add(c);
        int col=c.getPosizioneColonna();
        int riga=c.getPosizioneRiga();
        int cont=col;
        for(int i=riga;i>1  && cont<=altezza && cont>1;i--){
            Casella c1=villaggioD.getCasella(i-1, cont-1);
            cont--;
            g.add(c1);
        }
        cont=col;
        for(int i=riga;i<altezza && cont<lunghezza;i++){
            Casella c1=new Casella(cont+1,i+1);
            cont++;
            g.add(c1);
        }
        return g;

    }
    
}
