
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class RegolaUnoOttenimentoRisorsaStrategy implements OttenimentoRisorseStrategy  {

    @Override
    public ArrayList<Risorsa> ottieniRisorsa(Battaglia battaglia) {
        ArrayList<Risorsa> risorse= new ArrayList<Risorsa>();
        ArrayList<Deposito> depositi=battaglia.getGiocatoreD().getDepositi();
        for (int i=0;i<depositi.size();i++){
            Deposito deposito=depositi.get(i);
            Risorsa r=deposito.getRisorsa();
                int ris=this.isInArray(r, risorse);
                Risorsa risorsaArray;
                int vita=deposito.getStatistica().getVita();
                int vitaMassima=deposito.getEdificioDescrizione().getVitaMassima();
                double x=((vitaMassima-vita)*30)/vitaMassima;
                double q2=x/100*r.getQuantita();
                if(ris>=0){
                    risorsaArray=risorse.get(ris);
                    double quantita=risorsaArray.getQuantita()+q2;
                    risorsaArray.setQuantita(quantita);
                    risorse.set(ris, risorsaArray);
                }
                else{
                    String className= "com.mycompany.progettoclash."+r.getNome();
                    try {
                        Class cls = Class.forName(className);
                        risorsaArray = (Risorsa) cls.newInstance();
                        risorsaArray.setQuantita(q2);
                        risorse.add(risorsaArray);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        return null;
                    }
                }  
        }
        return risorse;
    }
      
         
    private int isInArray(Risorsa r,ArrayList<Risorsa> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNome().equals(r.getNome())){
                return i;
            }
        }
        return -1;
    }

    
        
    }
    

