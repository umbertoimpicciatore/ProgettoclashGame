package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PotenziamentoEroeStrategy implements PotenziamentoStrategy  {
    
    int attaccoDaPot=5;
    int difesaDaPot=5;
    int vitaDaPot=5;
    int livelloPerPot=10;
    
  @Override
    public void potenziaEroe(EroeDescrizione desc,int quantita, Giocatore giocatore) {
        
        try {
            ArrayList<Eroe> listE=new ArrayList<Eroe>();
            int livelloEroi=giocatore.getLivelloEroi().get(desc);
            Statistica statIn=desc.getStatisticaIniziale();
            int difesaEroe=statIn.getDifesa()*livelloEroi;
            int attaccoEroe=statIn.getAttacco()*livelloEroi;
            int vitaEroe=statIn.getVita()*livelloEroi;
            Statistica stat=new Statistica(difesaEroe,attaccoEroe,vitaEroe);
            String className=desc.getNome().concat("Builder");
            Class cls = Class.forName(className);
            EroeBuilder instanzaEroe = (EroeBuilder) cls.newInstance(); 
            for (int i=0;i<quantita;i++){
                instanzaEroe.setId(i);
                EroeDirector erD=new EroeDirector();
                Eroe eroe;
                if(livelloEroi>=livelloPerPot){
                    eroe=erD.createEroePotenziato(instanzaEroe,stat);
                }
                else{
                    eroe=erD.createEroe(instanzaEroe,stat);
                } 
                listE.add(eroe);
            }
            giocatore.getAccampamento().setListaEroiGiocatore(listE);

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(PotenziamentoEroeStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}