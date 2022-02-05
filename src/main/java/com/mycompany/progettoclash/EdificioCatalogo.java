
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class EdificioCatalogo {
    private HashMap<Edificio,EdificioDescrizione > descrizioni;
    
    public EdificioCatalogo(){
        descrizioni= new HashMap<>();
        loadEdificiDescrizioni();
    }
    
    public EdificioDescrizione getEdificioDescrizione(Edificio edificio){
        return descrizioni.get(edificio);
    }
    
    
    public ArrayList<EdificioDescrizione> getAllEdificiDescrizioni(){
       return PersistanManager.getInstance().getAllEdificiDescrizioni();
    }
    
    public EdificioDescrizione getDescrizione(int idEdificioDesc){
         return PersistanManager.getInstance().getEdificioDescrizioni(idEdificioDesc);
    }
    
    
    private void loadEdificiDescrizioni(){

        int idDescrizione = 1;
        String nome = "Accampamento";
        int quantitaMassima = 1;
        Risorsa prezzoDiAcquisto = new Oro(10);
        int vitaMassima = 100;
        Statistica statistica = new Statistica(10,10,100);
        ModalitàAttacco modA=null;
        EdificioDescrizione ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        
        idDescrizione = 2;
        nome = "Accademia";
        quantitaMassima = 1;
        prezzoDiAcquisto = new Oro(5);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        
        
        idDescrizione = 3;
        nome = "Municipio";
        quantitaMassima = 1;
        prezzoDiAcquisto = new Oro(15);
        vitaMassima = 120;
        statistica = new Statistica(10,10,120);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        
        idDescrizione = 4;
        nome = "Torre";
        quantitaMassima = 3;
        prezzoDiAcquisto = new Oro(20);
        vitaMassima = 100;
        statistica = new Statistica(10,30,100);
        modA=new AttaccaTorre();
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        
        idDescrizione = 5;
        nome = "DepositoOro";
        quantitaMassima = 2;
        prezzoDiAcquisto = new Oro(20);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        
        
        idDescrizione = 6;
        nome = "DepositoMana";
        quantitaMassima = 2;
        prezzoDiAcquisto = new Mana(20);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA);
        

        
        
    }
}