package com.mycompany.progettoclash;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class CreaEdificioFactory {
    private static CreaEdificioFactory instance = null; 
    private CreaEdificioFactory() {} 
 
    public static CreaEdificioFactory getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new CreaEdificioFactory();
        }
        return instance;
    }
    
    public Edificio getEdificio(EdificioDescrizione desc){

        String nome=desc.getNome();
        if(nome.equals("DepositoOro")){
            return new DepositoOro(new Oro(0));
        }
        else if(nome.equals("DepositoMana")){
            return new DepositoMana(new Mana(0));
        }
        else{
            try {
                String className= "com.mycompany.progettoclash.".concat(nome);
                Class cls = Class.forName(className);
                Edificio edificio = (Edificio) cls.newInstance();
                return edificio;
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(CreaEdificioFactory.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
}
