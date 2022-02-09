package com.mycompany.progettoclash;
import com.mycompany.progettoclash.Foundation.Descrizioni;
import com.mycompany.progettoclash.view.ViewAcquista;
import com.mycompany.progettoclash.view.ViewAttacco;
import com.mycompany.progettoclash.view.ViewIniziale;
import com.mycompany.progettoclash.view.ViewPotenzia;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class Main {
    public static void main(String[] args){

        String nome;
        int idDesc=1;
        int quantitaMassima;
        Risorsa prezzoDiAcquisto;
        Risorsa prezzoDiPotenziamento;
        int vitaMassima;
        EroeDescrizione ed;
        Statistica si=new Statistica(8,5,100);
        Statistica si2=new Statistica(5,10,100);
        Statistica si3=new Statistica(10,10,100);
        ModalitàAttacco modA=new AttaccaAvanti();
        ModalitàAttacco modA1=new AttaccaDuePosizioni();
        ModalitàAttacco modA2=new AttaccaDiagonale();
        
        

        nome="Arciere";
        quantitaMassima=2;
        prezzoDiAcquisto=new Oro(4);
        prezzoDiPotenziamento=new Oro(5);
        vitaMassima=100;
        ed=new EroeDescrizione(idDesc,nome,quantitaMassima,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si,modA1);
        ed.setEroi(null);
        Descrizioni.arciere=ed;
        

        nome="Guerriero";
        quantitaMassima=3;
        prezzoDiAcquisto=new Oro(3);
        prezzoDiPotenziamento=new Oro(4);
        vitaMassima=100;
        ed=new EroeDescrizione(idDesc+1,nome,quantitaMassima,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si2,modA);
        ed.setEroi(null);
        Descrizioni.guerriero=ed;
        
        nome="Regina";
        quantitaMassima=1;
        prezzoDiAcquisto=new Mana(5);
        prezzoDiPotenziamento=new Mana(6);
        vitaMassima=100;
        ed=new EroeDescrizione(idDesc+2,nome,quantitaMassima,prezzoDiAcquisto,prezzoDiPotenziamento,vitaMassima,si3,modA2);
        ed.setEroi(null);
        Descrizioni.regina=ed;
        
        Main.iniziaDescrizioni();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //creo GIOCATORE ATTACCANTE
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Deposito dep1=new DepositoOro(new Oro(0));
        Deposito dep2=new DepositoMana(new Mana(0));
        dep1.setEdificioDescrizione(Descrizioni.depositoOro);
        dep2.setEdificioDescrizione(Descrizioni.depositoMana);
        dep1.setId(0);
        dep2.setId(2);
        Oro oro=new Oro(5);
        Mana mana=new Mana(3);
        dep1.setRisorsa(oro);
        dep2.setRisorsa(mana);
        
        Giocatore ga=new Giocatore();
        Municipio municipio=new Municipio();
        //Statistica s0=new Statistica(5,5,100);
        municipio.setEdificioDescrizione(Descrizioni.municipio);
        ga.setMunicipio(municipio);
        ArrayList<Deposito> depositi = new ArrayList<Deposito>();
        depositi.add(dep1);
        ga.setDepositiOro(depositi);
        ArrayList<Deposito> depositi2 = new ArrayList<Deposito>();
        depositi2.add(dep2);
        ga.setDepositiMana(depositi2);
        Accampamento acc2=new Accampamento();
        Statistica s1=new Statistica(5,5,100);
        Statistica s2=new Statistica(10,5,100);
        acc2.setId(2);
        acc2.setEdificioDescrizione(Descrizioni.accampamento);
        Accademia accademia=new Accademia();
        
        
        ArciereBuilder arc2=new ArciereBuilder();
        EroeDirector eroeDirector=new EroeDirector(arc2);
        Eroe e=eroeDirector.createEroe2(s1, new SkinBase(), 1);
        //Descrizioni.arciere.setEroi(eroi);
        ArrayList<Eroe> list=new ArrayList<Eroe>();
        list.add(e);
        e=eroeDirector.createEroe2(s2, new SkinBase(), 2);
        list.add(e);
        Descrizioni.arciere.setEroi(list);
        /*ArciereBuilder arc2=new ArciereBuilder();
        arc2.setId(1);
        EroeDescrizione desc1=new EroeDescrizione();
        desc1.setIdDesc(1);//da MODIFICARE
        desc1.setNome("Arciere");
        EroeDescrizione desc2=new EroeDescrizione();
        desc2.setIdDesc(1);//da MODIFICARE
        desc2.setNome("Arciere");
        Statistica s2=new Statistica(5,5,100);
        Statistica s3=new Statistica(5,5,100);
        EroeDirector erD2=new EroeDirector();
        Eroe eroeArc2=erD2.createEroe(arc2,s2);
        eroeArc2.setEroeDescrizione(desc1);
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(2);
        
        EroeDirector erD3=new EroeDirector();
        Eroe eroeArc3=erD3.createEroe(arc3,s3);
        eroeArc3.setEroeDescrizione(desc1);*/
        
        //list.add(eroeArc3);
        acc2.setListaEroiGiocatore(list);
        Villaggio v2=new Villaggio();
        for (int i=1;i<=v2.getAltezza();i++){
            for (int j=1;j<=v2.getLarghezza();j++){
                Casella c=new Casella(i,j);
                if(i==1 &&j==1){
                    c.setEdificio(acc2);
                    acc2.setCasella(c);
                }     
                if(i==1 &&j==2){
                    c.setEdificio(dep1);
                    dep1.setCasella(c);
                }
                if(i==1 &&j==3){
                    c.setEdificio(dep2);
                    dep2.setCasella(c);
                }
                if(i==1 &&j==4){
                    c.setEdificio(municipio);
                    municipio.setCasella(c);
                }
                c.setVillaggio(v2);
                caselle.add(c);
            }
        }
        v2.setCaselle(caselle);
      //  acc2.sacc2.
        acc2.setGiocatore(ga);
        ga.setAccampamento((Accampamento)acc2);      
        ga.setVillaggio(v2);
        ga.setAccademia(accademia);
        //ViewAttacco view2=new ViewAttacco();
        //view2.cercaAvversario(ga);
        
        EroeCatalogo  catalogo=new EroeCatalogo();
        
        ArrayList<EroeDescrizione> desc=catalogo.getAllDescrizioni();
        HashMap<EroeDescrizione,Integer> livelloEroi=new HashMap<EroeDescrizione,Integer>();
        for(int i=0;i<desc.size();i++){
            
            if(i==2){
                livelloEroi.put(desc.get(i), 10);
            }
            else{
                livelloEroi.put(desc.get(i), i+1);
            }
        }        
        ga.setLivelloEroi(livelloEroi);
        //ViewPotenzia view=new ViewPotenzia();
        //view.selezionaOperazione(ga);
        //ViewAttacco view=new ViewAttacco();
        //view.cercaAvversario(ga);
        ViewIniziale view=new ViewIniziale();
        view.selezionaOperazione(ga);
    }
    
    public static void iniziaDescrizioni(){
        int idDescrizione = 1;
        String nome = "Accampamento";
        int quantitaMassima = 1;
        int quantitaMassimaImm=0;
        Risorsa prezzoDiAcquisto = new Oro(10);
        int vitaMassima = 100;
        Statistica statistica = new Statistica(10,10,100);
        ModalitàAttacco modA=null;
        EdificioDescrizione ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.accampamento=ed;
        
        idDescrizione = 2;
        nome = "Accademia";
        quantitaMassima = 1;
        quantitaMassimaImm=0;
        prezzoDiAcquisto = new Oro(5);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.accademia=ed;
        
        idDescrizione = 3;
        nome = "Municipio";
        quantitaMassima = 1;
        quantitaMassimaImm=0;
        prezzoDiAcquisto = new Oro(15);
        vitaMassima = 120;
        statistica = new Statistica(10,10,120);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.municipio=ed;
        
        idDescrizione = 4;
        nome = "Torre";
        quantitaMassimaImm=0;
        quantitaMassima = 3;
        prezzoDiAcquisto = new Oro(20);
        vitaMassima = 100;
        statistica = new Statistica(10,30,100);
        modA=new AttaccaTorre();
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.torre=ed;
        
        idDescrizione = 5;
        nome = "DepositoOro";
        quantitaMassima = 2;
        quantitaMassimaImm=20;
        prezzoDiAcquisto = new Oro(20);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.depositoOro=ed;
        
        idDescrizione = 6;
        nome = "DepositoMana";
        quantitaMassima = 2;
        quantitaMassimaImm=20;
        prezzoDiAcquisto = new Mana(20);
        vitaMassima = 100;
        statistica = new Statistica(10,10,100);
        modA=null;
        ed=new EdificioDescrizione(null,idDescrizione,nome,quantitaMassima,prezzoDiAcquisto,vitaMassima,statistica,modA,quantitaMassimaImm);
        Descrizioni.depositoMana=ed;

    }

}