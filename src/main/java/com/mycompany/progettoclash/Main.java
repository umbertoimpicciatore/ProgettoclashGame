package com.mycompany.progettoclash;
import com.mycompany.progettoclash.Foundation.Descrizioni;
import com.mycompany.progettoclash.Foundation.GiocatoreF;
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
        Main.Giocatore();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //creo GIOCATORE ATTACCANTE
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Deposito dep1=new DepositoOro(new Oro(0),Descrizioni.depositoOro);
        Deposito dep2=new DepositoMana(new Mana(0),Descrizioni.depositoMana);
       // dep1.setEdificioDescrizione(Descrizioni.depositoOro);
       // dep2.setEdificioDescrizione(Descrizioni.depositoMana);
        dep1.setId(0);
        dep2.setId(2);
        Oro oro=new Oro(5);
        Mana mana=new Mana(3);
        dep1.setRisorsa(oro);
        dep2.setRisorsa(mana);
        
        Giocatore ga=new Giocatore();
        Municipio municipio=new Municipio(Descrizioni.municipio);
        //Statistica s0=new Statistica(5,5,100);
        ga.setMunicipio(municipio);
        ArrayList<Deposito> depositi3 = new ArrayList<Deposito>();
        depositi3.add(dep2);
        depositi3.add(dep1);
        ga.setDepositi(depositi3);
        Accampamento acc2=new Accampamento(Descrizioni.accampamento);
        Statistica s1=new Statistica(5,5,100);
        Statistica s2=new Statistica(10,5,100);
        acc2.setId(2);
        //acc2.setEdificioDescrizione(Descrizioni.accampamento);
        Accademia accademia=new Accademia(Descrizioni.accademia);
        
        
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
                if(i==2 && j==2){
                    c.setEdificio(accademia);
                    accademia.setCasella(c);
                }
                c.setVillaggio(v2);
                caselle.add(c);
            }
        }
        v2.setCaselle(caselle);
        acc2.setGiocatore(ga);
        ga.setAccampamento((Accampamento)acc2);      
        ga.setVillaggio(v2);
        ga.setAccademia(accademia);

        
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
        view.selezionaOperazione(ga,false);
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
        modA=new AttaccaTutto();
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
    
    public static void Giocatore(){
            Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Villaggio v=new Villaggio();
        Edificio e=new Municipio(Descrizioni.municipio);
//        Statistica s=new Statistica(5,5,100);
//        Statistica s1=new Statistica(5,5,100);
//        e.setStatistica(s);
        e.setId(1);
        Edificio torre=new Torre(Descrizioni.torre);
        //torre.setEdificioDescrizione(Descrizioni.torre);
        Edificio e2=new Municipio(Descrizioni.municipio);
//        e2.setStatistica(s1);
        e2.setId(1);
        e2.setEdificioDescrizione(Descrizioni.municipio);
        //EdificioDescrizione desc1=new EdificioDescrizione();
        //desc1.setNome("Deposito");
        //EdificioDescrizione desc2=new EdificioDescrizione();
        //desc2.setNome("Accampamento");
        Deposito dep1=new DepositoOro(new Oro(2),Descrizioni.depositoOro);
        Deposito dep2=new DepositoOro(new Oro(3),Descrizioni.depositoOro);
        Deposito dep3=new DepositoMana(new Mana(4),Descrizioni.depositoMana);
        Deposito dep4=new DepositoMana(new Mana(5),Descrizioni.depositoMana);
//        Statistica s2=new Statistica(5,5,100);
//        Statistica s3=new Statistica(5,5,100);
//        Statistica s4=new Statistica(5,5,100);
//        Statistica s5=new Statistica(5,5,100);
//        dep1.setStatistica(s3);
//        dep2.setStatistica(s2);
//        dep3.setStatistica(s4);
//        dep4.setStatistica(s5);
        dep1.setId(0);
        dep2.setId(2);
        dep3.setId(3);
        dep4.setId(4);
        dep1.setEdificioDescrizione(Descrizioni.depositoOro);
        dep2.setEdificioDescrizione(Descrizioni.depositoOro);
        dep3.setEdificioDescrizione(Descrizioni.depositoMana);
        dep4.setEdificioDescrizione(Descrizioni.depositoMana);
        /*dep1.setEdificioDescrizione(desc1);
        dep2.setEdificioDescrizione(desc1);
        dep3.setEdificioDescrizione(desc1);
        dep4.setEdificioDescrizione(desc1);*/
        e.setEdificioDescrizione(Descrizioni.municipio);
       // e2.setEdificioDescrizione(desc2);
        Oro oro=new Oro(2);
        Mana mana=new Mana(3);
        Oro oro2=new Oro(5);
        Mana mana2=new Mana(7);
        dep1.setRisorsa(oro);
        dep2.setRisorsa(oro2);
        dep3.setRisorsa(mana);
        dep4.setRisorsa(mana2);

        ArrayList<Deposito> depositi = new ArrayList<Deposito>();
        depositi.add(dep1);
        depositi.add(dep2);
        depositi.add(dep3);
        depositi.add(dep4);
        g.setDepositi(depositi);
        
       //creo VILLAGGIO
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c=new Casella(i,j);
                
                
                if(i==1 &&j==1){
                   // c.AddEroe(eroeArc);
                    c.setEdificio(e);
                   // eroeArc.setC(c);
                    e.setCasella(c);
                }
                if(i==4 &&j==4){
                    c.setEdificio(e2);
                    e2.setCasella(c);
                }
                if(i==3 &&j==3){
                    c.setEdificio(dep1);
                    dep1.setCasella(c);
                }
                if(i==2 &&j==2){
                    c.setEdificio(dep2);
                    dep2.setCasella(c);
                }
                if(i==2 &&j==4){
                    c.setEdificio(dep3);
                    dep3.setCasella(c);
                }
                if(i==1 &&j==4){
                    c.setEdificio(dep4);
                    dep4.setCasella(c);
                }
                if(i==1 && j==3){
                    c.setEdificio(torre);
                    torre.setCasella(c);
                }
                c.setVillaggio(v);
                caselle.add(c);
            }
        }
        
        v.setCaselle(caselle);
        g.setVillaggio(v);
       GiocatoreF.list.add(g);
    }

}