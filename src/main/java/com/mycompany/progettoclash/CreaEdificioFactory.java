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
    
    public Edificio getEdificio(EdificioDescrizione desc,Giocatore g){

        String nome=desc.getNome();
        if(nome.equals("DepositoOro")){
            Deposito depOro=new DepositoOro(new Oro(0));
            depOro.setEdificioDescrizione(desc);
            g.getDepositiOro().add(depOro);
            return depOro;
        }
        else if(nome.equals("DepositoMana")){
            Deposito depMana=new DepositoMana(new Mana(0));
            depMana.setEdificioDescrizione(desc);
            g.getDepositiMana().add(depMana);
            return depMana;
        }
        else{
            try {
                String className= "com.mycompany.progettoclash.".concat(nome);
                Class cls = Class.forName(className);
                Edificio edificio = (Edificio) cls.newInstance();
                edificio.setEdificioDescrizione(desc);
                return edificio;
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(CreaEdificioFactory.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
}
