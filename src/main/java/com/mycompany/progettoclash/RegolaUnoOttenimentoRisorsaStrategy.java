
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class RegolaUnoOttenimentoRisorsaStrategy implements OttenimentoRisorseStrategy {

    @Override
    public Risorsa ottieniRisorsa(ClashGame clash) {
        //DA IMPLEMENTARE

         Villaggio villaggioD=clash.getGiocatoreD().getVillaggio();
         ArrayList<Casella>  c=villaggioD.getCaselle();
         ArrayList<Risorsa> risorse=new ArrayList();
         double acc=0;
         for(int i=0;i<=c.size();i++){
                 Edificio ed=c.get(i).getEdificio();
                 if (ed.getEdificioDescrizione().getNome().equals("Deposito")){
                            
                            Risorsa risorsaD=clash.getGiocatoreD().getDeposito().getRisorsa();
                            double risorseIniziali=risorsaD.getQuantita();
//                            Risorsa risorsaA=clash.getGiocatoreA().getDeposito().getRisorsa();
                            Deposito depositoD=(Deposito) ed;
//                            Deposito depositoA=clash.getGiocatoreA().getDeposito();
                            int vitaMassimaDepositoD=depositoD.getEdificioDescrizione().getVitaMassima();
       
                            int vitaAttualeD=depositoD.getStatistica().getVita();
        
                            double a=vitaAttualeD/vitaMassimaDepositoD *depositoD.getRisorsa().getQuantita();
                           acc=acc+a;
                            Risorsa r1 = depositoD.getRisorsa();
                            
                            r1.setQuantita(a);
                            risorse.add(r1);
                            depositoD.getRisorsa().setQuantita(risorseIniziali-a);
                           
                 
//Risorsa nuovarisorsaD=clash.getGiocatoreD().getDeposito().s
//                          depositoD.getRisorsa().setQuantità(risorsaD.getQuantita()-a);
//      //  depositoD.setRisorsa(risorsa);
//        depositoA.getRisorsa().setQuantità(risorsaA.getQuantita()+a);
                 
                 }
         
         }
          return r1;
//         int a=clash.getGiocatoreD().getVillaggio().getDanni()+deposito.getDanni()/deposito.getS().getVita()*deposito.getOro().getQuantita();
//         return new Risorsa(a);
        
    }
        
    }
    

