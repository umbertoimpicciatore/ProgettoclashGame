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
public class AttaccaDuePosizioni implements ModalitàAttacco{
    @Override
    public ArrayList<Casella> attacco(Eroe e){
        
//        ArrayList<Casella> g=new ArrayList<Casella>();
//        g.add(e.getC());
//        Villaggio villaggioD=e.getC().getVillaggio();
//        int col=e.getC().getPosizioneColonna();
//        int r=e.getC().getPosizioneRiga();
        
        //prima prova ciclo
//        for (int i=r-1;i<(r+1) && i>(-1) && i<3; i++ ){
//            for (int j=col-1; j>1 && j<(col+1) && j<3 ;j++){
//                Casella c2= new Casella(i,j);
//                g.add(c2);
//                
//            }
//        
//        }
//        for (int i=r;i<=r+1 && i>=r-1;i++){
//             for (int j=col; j<=col+1&& j>=col-1;j++){
ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        Villaggio villaggioD=e.getC().getVillaggio();
        int col=e.getC().getPosizioneColonna();
        int r=e.getC().getPosizioneRiga();
                int i=r;int j=col;
                 Casella c1= villaggioD.getCasella(i-1,j);
                 Casella c2= villaggioD.getCasella(i+1,j);
                 Casella c3= villaggioD.getCasella(i,j-1);
                 Casella c4= villaggioD.getCasella(i,j+1);
                 
                
                 if (i-1>=0 && c1.getEdificio().getStatistica().getVita()!=0 && c1.getEdificio()!=null)
                 {g.add(c1);}
                 if (i+1<=3 &&c1.getEdificio().getStatistica().getVita()!=0 && c1.getEdificio()!=null)
                 {g.add(c2);}
                 if (j-1>=0 && c1.getEdificio().getStatistica().getVita()!=0 && c1.getEdificio()!=null)
                 {g.add(c3);}
                 if (j+1<=3 && c1.getEdificio().getStatistica().getVita()!=0 && c1.getEdificio()!=null)
                 {g.add(c4);}
                 
                 return g;
             
             }
        
                
            
        
        
//        Casella c2=new Casella(col+1,r+1);
        //c2.setPosizioneColonna(col+1);
        //c2.setPosizioneRiga(r+1);
        //g.add(c2);
        
        //System.out.println("attacca Due Posizioni");
        //System.out.println(e.getC().getPosizioneRiga());

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }
    
}
