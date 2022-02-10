
package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class RegolaUnoOttenimentoRisorsaStrategy implements OttenimentoRisorseStrategy  {

    @Override
    public ArrayList<Risorsa> ottieniRisorsa(Battaglia battaglia) {
    
        ArrayList<Risorsa> risorse= new ArrayList<Risorsa>();
        ArrayList<Casella>  c=battaglia.caselleDifensore();
        for(int i=0;i<c.size();i++){
            Casella casella=c.get(i);
            Edificio edificio=casella.getEdificio();
            if(edificio!=null && edificio instanceof Deposito){ //&& edificio.getEdificioDescrizione().getNome().equals("Deposito")
                Deposito deposito=(Deposito) edificio;
                Risorsa r=deposito.getRisorsa();
                int ris=this.isInArray(r, risorse);
                Risorsa risorsaArray;
                if(ris>=0){
                    risorsaArray=risorse.get(ris);
                    double quantita=risorsaArray.getQuantita()+r.getQuantita();
                    risorsaArray.setQuantita(quantita);
                    risorse.set(ris, risorsaArray);
                }
                else{
                    String className= "com.mycompany.progettoclash."+r.getNome();
                    double quantita=r.getQuantita();
                    try {
                        Class cls = Class.forName(className);
                        risorsaArray = (Risorsa) cls.newInstance();
                        risorsaArray.setQuantita(quantita);
                        risorse.add(risorsaArray);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        return null;
                    }
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
    

