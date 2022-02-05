
package com.mycompany.progettoclash.Foundation;

import com.mycompany.progettoclash.EdificioDescrizione;
import com.mycompany.progettoclash.EroeDescrizione;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Descrizioni {
    public static EroeDescrizione arciere;
    public static EroeDescrizione guerriero;
    public static EroeDescrizione regina;
    public static int ultimoIdEroe=2; 
    public static int ultimoIdEdificio=0;
    public static EdificioDescrizione depositoOro;
    public static EdificioDescrizione depositoMana;
    public static EdificioDescrizione accademia;
    public static EdificioDescrizione municipio;
    public static EdificioDescrizione accampamento;
    public static EdificioDescrizione torre;
    
    public ArrayList<EroeDescrizione> getAllDescrizioni(){
        ArrayList<EroeDescrizione> desc=new ArrayList<EroeDescrizione>();
        desc.add(regina);
        desc.add(arciere);
        desc.add(guerriero);
        return desc;     
    }
    
    public ArrayList<EdificioDescrizione> getAllEdifDescrizioni(){
        ArrayList<EdificioDescrizione> desc=new ArrayList<EdificioDescrizione>();
        desc.add(depositoOro);
        desc.add(depositoMana);
        desc.add(accademia);
        desc.add(municipio);
        desc.add(accampamento);
        desc.add(torre);
        return desc;     
    }
    public EdificioDescrizione getEdificoDescrizione(int idEdifDesc){
        if(idEdifDesc==depositoOro.getIdDescrizione()){
            return depositoOro;
        }
        else if(idEdifDesc==depositoMana.getIdDescrizione()){
            return depositoMana;
        }
        else if(idEdifDesc==accampamento.getIdDescrizione()){
            return accampamento;
        }
        else if(idEdifDesc==municipio.getIdDescrizione()){
            return municipio;
        }
        else if(idEdifDesc==accademia.getIdDescrizione()){
            return accademia;
        }
        else if(idEdifDesc==torre.getIdDescrizione()){
            return torre;
        }
        else{
            return null;
        }
        
    }
    
        public EroeDescrizione getEroeDescrizione(int idEroeDesc){
            if(idEroeDesc==arciere.getIdDesc()){
                return arciere;
            }
            else if(idEroeDesc==guerriero.getIdDesc()){
                return guerriero;
            }
            else if(idEroeDesc==regina.getIdDesc()){
                return regina;
            }
            else{
                return null;
            }
        
        }

    
}
