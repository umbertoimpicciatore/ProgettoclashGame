
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class RegolaUnoOttenimentoRisorsaStrategy implements OttenimentoRisorseStrategy {

    @Override
    public ArrayList<Risorsa> ottieniRisorsa(ClashGame clash) {
    
        ArrayList<Risorsa> risorse= new ArrayList<Risorsa>();
        ArrayList<Casella>  c=clash.caselleDifensore();
        for(int i=0;i<c.size();i++){
            Casella casella=c.get(i);
            Edificio edificio=casella.getEdificio();
            if(edificio!=null && edificio.getEdificioDescrizione().getNome().equals("Deposito")){
                Deposito deposito=(Deposito) edificio;
                Risorsa r=deposito.getRisorsa();
                int ris=this.isInArray(r, risorse);
                if(ris>=0){
                    Risorsa risorsaArray=risorse.get(ris);
                    double quantita=risorsaArray.getQuantita()+r.getQuantita();
                    risorsaArray.setQuantita(quantita);
                    risorse.set(ris, risorsaArray);
                }
                else{
                    risorse.add(r);
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
    

