/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.Descrizioni;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class MatchMakingBasedOnLvGiocatoreStrategy implements MatchMakingStrategy {

 
    @Override
    public Giocatore getAvversario(Giocatore g1) {
        Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Villaggio v=new Villaggio();
        Edificio e=new Municipio(Descrizioni.municipio);
//        Statistica s=new Statistica(5,5,100);
//        Statistica s1=new Statistica(5,5,100);
//        e.setStatistica(s);
        e.setId(1);
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
                c.setVillaggio(v);
                caselle.add(c);
            }
        }
        
        v.setCaselle(caselle);
        g.setVillaggio(v);
       return g;
           
        /*Giocatore g1=new Giocatore();
           Giocatore g2=new Giocatore();
           ArrayList<Giocatore> lista=new ArrayList<Giocatore>();
           lista.add(g1);
           lista.add(g2);
        for (int i=0;i<lista.size();i++){
            Giocatore avversario=lista.get(i);
            if (avversario.getLivello()==g.getLivello()){
                return avversario;
            }
        }
       return g1 ;*/
    }
    
}
