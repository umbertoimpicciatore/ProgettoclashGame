/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lorenzo
 */
public class MatchMakingBasedOnLvEroiStrategy implements MatchMakingStrategy{
    

    @Override
    public Giocatore getAvversario(Giocatore g) {
        Giocatore g1=new Giocatore();
        Giocatore g2=new Giocatore();
        ArrayList<Giocatore> lista=new ArrayList<Giocatore>();
        lista.add(g1);
        lista.add(g2);
        
//        ArrayList<Eroe> f=g.getEroi();
//        for (int k=0;k<f.size();k++){
//            l+=f.get(k).getLivello();
//        }
//        HashMap<EroeDescrizione,Integer> livelloEroi=g.getLivelloEroi();
//        for (EroeDescrizione key : livelloEroi.keySet()){
//        l+=livelloEroi.get(key);
//        }
        int l=g.getSommaLivelloEroi();
           
        for (int i=0;i<lista.size();i++){
            Giocatore avversario=lista.get(i);
            int l2=avversario.getSommaLivelloEroi();
            if (l2==l){return avversario;}
//            ArrayList <Eroe> er=avversario.getEroi();
//            int livelloeroi=0;
//            for (int j=0;j<er.size();j++){
//                livelloeroi+=er.get(j).getLivello();
//            }
//            if (livelloeroi==l){return avversario;}
//           
//            }
        }
    return null;
    }
    
    }
    

