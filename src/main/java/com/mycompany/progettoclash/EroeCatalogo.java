package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class EroeCatalogo {
    private HashMap<Eroe,EroeDescrizione > descrizioni;
    
    public EroeCatalogo(){
        descrizioni= new HashMap<>();
        //loadEroiDescrizioni();
    }
    
    public EroeDescrizione getEroeDescrizione(Eroe e){
        return descrizioni.get(e);
    }
    
    //carico dati "di prova" di tutte le descrizioni presenti su DB
    public ArrayList<EroeDescrizione> getAllDescrizioni(){
        return PersistanManager.getInstance().getAllDescrizioni();
    }
    
    //carico alcuni dati di prova
    private void loadEroiDescrizioni(){
        Eroe eroe;
        String nome;
        int quantitaMassima;
        int quantitaDisponibile;
        Risorsa prezzoDiAcquisto;
        Risorsa prezzoDiPotenziamento;
        int vitaMassima;
        EroeDescrizione ed;
        int idDesc=1;
        Statistica si=new Statistica(5,5,100);
        Statistica si2=new Statistica(5,5,100);
        Statistica si3=new Statistica(5,5,100);
        
        Statistica s2=new Statistica(5,5,100);
        Statistica s3=new Statistica(5,5,100);
        Statistica s4=new Statistica(5,5,100);
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(1);
        EroeDirector erD3=new EroeDirector();
        eroe=erD3.createEroe(arc3,s2);
        nome="Arciere";
        quantitaMassima=2;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(3);
        prezzoDiPotenziamento=new Oro(4);
        vitaMassima=100;
        
        ed=new EroeDescrizione(idDesc,nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si);
        descrizioni.put(eroe, ed);
        
        GuerrieroBuilder g=new GuerrieroBuilder();
        g.setId(2);
        EroeDirector erD=new EroeDirector();
        eroe=erD.createEroe(g,s3);
        nome="Guerriero";
        quantitaMassima=3;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(4);
        prezzoDiPotenziamento=new Oro(5);
        vitaMassima=100;
        ed=new EroeDescrizione(idDesc+1,nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si2);
        descrizioni.put(eroe, ed);
        
        
        
        ReginaBuilder r=new ReginaBuilder();
        r.setId(3);
        EroeDirector erD1=new EroeDirector();
        eroe=erD1.createEroe(r,s4);
        nome="Regina";
        quantitaMassima=1;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(5);
        prezzoDiPotenziamento=new Oro(6);
        vitaMassima=100;
        ed=new EroeDescrizione(idDesc+2,nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si3);
        descrizioni.put(eroe, ed);
        
    }
    
    public EroeDescrizione getEroeDescrizione(int idEroeDesc){
        return PersistanManager.getInstance().getEroeDescrizione(idEroeDesc);
       
    }
}
