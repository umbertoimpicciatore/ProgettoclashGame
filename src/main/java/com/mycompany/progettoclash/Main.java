package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewAcquista;
import com.mycompany.progettoclash.view.ViewAttacco;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class Main {
    public static void main(String[] args){
        /*
        Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Villaggio v=new Villaggio();
        Edificio e=new Municipio(new AttaccaAvanti());
        Edificio acc=new Accampamento(new AttaccaAvanti());
        Statistica s=new Statistica(5,5,100);
        acc.setStatistica(s);
        acc.setId(2);
        e.setStatistica(s);
        e.setId(1);
        ArciereBuilder arc=new ArciereBuilder();
        EroeDirector erD=new EroeDirector();
        Eroe eroeArc=erD.createEroe(arc);
        //Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        
       //creo VILLAGGIO
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c=new Casella(i,j);
                
                
                if(i==1 &&j==1){
                    c.AddEroe(eroeArc);
                    c.setEdificio(e);
                    eroeArc.setC(c);
                    e.setCasella(c);
                }
                if(i==1 &&j==2){
                    c.setEdificio(acc);
                    acc.setCasella(c);
                }
                
                c.setVillaggio(v);
                caselle.add(c);
            }
        }
          // g.setVillaggio(v);
       // Objects.isNull(g.getVillaggio().getCasella(1, 1).getVillaggio());
        v.setCaselle(caselle);*/
        
        //creo GIOCATORE ATTACCANTE
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Deposito dep1=new Deposito(new AttaccaAvanti());
        Deposito dep2=new Deposito(new AttaccaAvanti());
        dep1.setId(0);
        dep2.setId(2);
        Oro oro=new Oro(2);
        Mana mana=new Mana(3);
        dep1.setRisorsa(oro);
        dep2.setRisorsa(mana);
        
        Giocatore ga=new Giocatore();
        Edificio acc2=new Accampamento(new AttaccaAvanti());
        Statistica s1=new Statistica(5,5,100);
        acc2.setStatistica(s1);
        acc2.setId(2);
        
        
        ArciereBuilder arc2=new ArciereBuilder();
        arc2.setId(1);
        Statistica s2=new Statistica(5,5,100);
        Statistica s3=new Statistica(5,5,100);
        EroeDirector erD2=new EroeDirector();
        Eroe eroeArc2=erD2.createEroe(arc2,s2);
        ArciereBuilder arc3=new ArciereBuilder();
        arc3.setId(2);
        EroeDirector erD3=new EroeDirector();
        Eroe eroeArc3=erD3.createEroe(arc3,s3);
        ArrayList<Eroe> list=new ArrayList<Eroe>();
        list.add(eroeArc2);
        list.add(eroeArc3);
        acc2.setListaEroiGiocatore(list);
        Villaggio v2=new Villaggio();
        for (int i=1;i<=v2.getAltezza();i++){
            for (int j=1;j<=v2.getLarghezza();j++){
                Casella c=new Casella(i,j);
                if(i==1 &&j==1){
                    c.AddEroe(eroeArc2);
                    c.setEdificio(acc2);
                    eroeArc2.setC(c);
                    acc2.setCasella(c);
                }      
                c.setVillaggio(v2);
                caselle.add(c);
            }
        }
        ga.setAccampamento((Accampamento)acc2);
        ga.setVillaggio(v2);

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
        ViewAcquista view=new ViewAcquista();
        view.selezionaOperazione(ga);
        
    }
        
}