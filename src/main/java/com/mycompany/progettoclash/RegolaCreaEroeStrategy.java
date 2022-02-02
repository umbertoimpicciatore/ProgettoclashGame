package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RegolaCreaEroeStrategy implements CreaEroeStrategy  {
    
    int attaccoDaPot=5;
    int difesaDaPot=5;
    int vitaDaPot=5;
    int livelloPerPot=10;
    
  @Override
    public void creaEroe(EroeDescrizione desc,int quantita, Giocatore giocatore) {
        
        try {
            ArrayList<Eroe> listE=new ArrayList<Eroe>();
            int livelloEroi=giocatore.getLivelloEroi().get(desc);
            Statistica statIn=desc.getStatisticaIniziale();
            int difesaEroe=statIn.getDifesa()+(difesaDaPot*livelloEroi);
            int attaccoEroe=statIn.getAttacco()+(attaccoDaPot*livelloEroi);
            int vitaEroe=statIn.getVita()+(vitaDaPot*livelloEroi);
            Statistica stat=new Statistica(difesaEroe,attaccoEroe,vitaEroe);
            String className="com.mycompany.progettoclash.".concat(desc.getNome().concat("Builder"));
            Class cls = Class.forName(className);
            EroeBuilder instanzaEroe = (EroeBuilder) cls.newInstance(); 
            for (int i=0;i<quantita;i++){
                instanzaEroe.setId(i);
                EroeDirector erD=new EroeDirector();
                Eroe eroe;
                if(livelloEroi>=livelloPerPot){
                    eroe=erD.createEroe2(instanzaEroe,stat,new SkinPotenziata());
                }
                else{
                    eroe=erD.createEroe2(instanzaEroe,stat,new SkinBase());
                } 
                listE.add(eroe);
            }
            giocatore.getAccampamento().addEroi(listE);//addEroi
          /*  ArrayList<Eroe> listEroi=giocatore.getEroi();
            for (int i=0;i<listEroi.size();i++){
                System.out.println(listEroi.get(i).toString());
            }*/

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(RegolaCreaEroeStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}