
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

    public static EroeDescrizione getArciere() {
        return arciere;
    }

    public static void setArciere(EroeDescrizione arciere) {
        Descrizioni.arciere = arciere;
    }

    public static EroeDescrizione getGuerriero() {
        return guerriero;
    }

    public static void setGuerriero(EroeDescrizione guerriero) {
        Descrizioni.guerriero = guerriero;
    }

    public static EroeDescrizione getRegina() {
        return regina;
    }

    public static void setRegina(EroeDescrizione regina) {
        Descrizioni.regina = regina;
    }

    public static int getUltimoIdEroe() {
        return ultimoIdEroe;
    }

    public static void setUltimoIdEroe(int ultimoIdEroe) {
        Descrizioni.ultimoIdEroe = ultimoIdEroe;
    }

    public static int getUltimoIdEdificio() {
        return ultimoIdEdificio;
    }

    public static void setUltimoIdEdificio(int ultimoIdEdificio) {
        Descrizioni.ultimoIdEdificio = ultimoIdEdificio;
    }

    public static EdificioDescrizione getDepositoOro() {
        return depositoOro;
    }

    public static void setDepositoOro(EdificioDescrizione depositoOro) {
        Descrizioni.depositoOro = depositoOro;
    }

    public static EdificioDescrizione getDepositoMana() {
        return depositoMana;
    }

    public static void setDepositoMana(EdificioDescrizione depositoMana) {
        Descrizioni.depositoMana = depositoMana;
    }

    public static EdificioDescrizione getAccademia() {
        return accademia;
    }

    public static void setAccademia(EdificioDescrizione accademia) {
        Descrizioni.accademia = accademia;
    }

    public static EdificioDescrizione getMunicipio() {
        return municipio;
    }

    public static void setMunicipio(EdificioDescrizione municipio) {
        Descrizioni.municipio = municipio;
    }

    public static EdificioDescrizione getAccampamento() {
        return accampamento;
    }

    public static void setAccampamento(EdificioDescrizione accampamento) {
        Descrizioni.accampamento = accampamento;
    }

    public static EdificioDescrizione getTorre() {
        return torre;
    }

    public static void setTorre(EdificioDescrizione torre) {
        Descrizioni.torre = torre;
    }
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
