package com.mycompany.progettoclash;

import java.util.ArrayList;

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
        

            ArrayList<Eroe> listE=new ArrayList<Eroe>();
            int livelloEroi=giocatore.getLivelloEroi().get(desc);
            Statistica statIn=desc.getStatisticaIniziale();
            int difesaEroe=statIn.getDifesa()+(difesaDaPot*livelloEroi);
            int attaccoEroe=statIn.getAttacco()+(attaccoDaPot*livelloEroi);
            int vitaEroe=statIn.getVita()+(vitaDaPot*livelloEroi);
            Statistica stat=new Statistica(difesaEroe,attaccoEroe,vitaEroe);
            EroeBuilder builder=new ArciereBuilder();
            EroeDirector eroeDirector=new EroeDirector(builder);
            for (int i=0;i<quantita;i++){
                Eroe eroe;
                if(livelloEroi>=livelloPerPot){
                    eroe=eroeDirector.createEroe2(stat,new SkinPotenziata(),desc,1);
                }
                else{
                    eroe=eroeDirector.createEroe2(stat,new SkinBase(),desc,1);
                } 
                listE.add(eroe);
            }
            giocatore.getAccampamento().addEroi(listE);//addEroi
          /*  ArrayList<Eroe> listEroi=giocatore.getEroi();
            for (int i=0;i<listEroi.size();i++){
                System.out.println(listEroi.get(i).toString());
            }*/


    }
}