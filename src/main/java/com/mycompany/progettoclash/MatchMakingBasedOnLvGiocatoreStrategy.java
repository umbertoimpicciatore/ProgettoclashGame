/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class MatchMakingBasedOnLvGiocatoreStrategy implements MatchMakingStrategy {

    public MatchMakingBasedOnLvGiocatoreStrategy() {
    }
 
    @Override
    public Giocatore getAvversario(Giocatore g) {
           Giocatore g1=new Giocatore();
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
       return g1 ;
    }
    
}
