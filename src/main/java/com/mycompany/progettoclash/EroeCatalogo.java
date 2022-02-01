package com.mycompany.progettoclash;

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
        loadEroiDescrizioni();
    }
    
    public EroeDescrizione getEroeDescrizione(Eroe e){
        return descrizioni.get(e);
    }
    
    //carico dati "di prova" di tutte le descrizioni presenti su DB
    public ArrayList<EroeDescrizione> getAllDescrizioni(){
        ArrayList<EroeDescrizione> desc=new ArrayList<EroeDescrizione>();
        Eroe eroe;
        String nome;
        int quantitaMassima;
        int quantitaDisponibile;
        Risorsa prezzoDiAcquisto;
        Risorsa prezzoDiPotenziamento;
        int vitaMassima;
        EroeDescrizione ed;
        
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(1);
        EroeDirector erD3=new EroeDirector();
        eroe=erD3.createEroe(arc3);
        nome="Arciere";
        quantitaMassima=2;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(3);
        prezzoDiPotenziamento=new Oro(4);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        desc.add(ed);
        
        GuerrieroBuilder g=new GuerrieroBuilder();
        g.setId(2);
        EroeDirector erD=new EroeDirector();
        eroe=erD.createEroe(g);
        nome="Guerriero";
        quantitaMassima=3;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(4);
        prezzoDiPotenziamento=new Oro(5);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        desc.add(ed);
        
        
        ReginaBuilder r=new ReginaBuilder();
        r.setId(3);
        EroeDirector erD1=new EroeDirector();
        eroe=erD1.createEroe(r);
        nome="Regina";
        quantitaMassima=1;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(5);
        prezzoDiPotenziamento=new Oro(6);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        desc.add(ed);
        return desc;
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
        
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(1);
        EroeDirector erD3=new EroeDirector();
        eroe=erD3.createEroe(arc3);
        nome="Arciere";
        quantitaMassima=2;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(3);
        prezzoDiPotenziamento=new Oro(4);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        descrizioni.put(eroe, ed);
        
        GuerrieroBuilder g=new GuerrieroBuilder();
        g.setId(2);
        EroeDirector erD=new EroeDirector();
        eroe=erD.createEroe(g);
        nome="Guerriero";
        quantitaMassima=3;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(4);
        prezzoDiPotenziamento=new Oro(5);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        descrizioni.put(eroe, ed);
        
        
        
        ReginaBuilder r=new ReginaBuilder();
        r.setId(3);
        EroeDirector erD1=new EroeDirector();
        eroe=erD1.createEroe(r);
        nome="Regina";
        quantitaMassima=1;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(5);
        prezzoDiPotenziamento=new Oro(6);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        descrizioni.put(eroe, ed);
        
    }
    
    public EroeDescrizione getEroeDescrizione(int idEroeDesc){
        ArrayList<Eroe> listEroi = new ArrayList<Eroe>();
        Eroe eroe;
        String nome;
        int quantitaMassima;
        int quantitaDisponibile;
        Risorsa prezzoDiAcquisto;
        Risorsa prezzoDiPotenziamento;
        int vitaMassima;
        EroeDescrizione ed;
        
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(1);
        EroeDirector erD3=new EroeDirector();
        eroe=erD3.createEroe(arc3);
        nome="Arciere";
        quantitaMassima=2;
        quantitaDisponibile=0;
        prezzoDiAcquisto=new Oro(3);
        prezzoDiPotenziamento=new Oro(4);
        vitaMassima=100;
        ed=new EroeDescrizione(nome,quantitaMassima,quantitaDisponibile,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima);
        listEroi.add(eroe);
        ed.setEroi(listEroi);
        return ed;
    }
}
