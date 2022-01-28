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
    
    int altezza=4;//mettere gli attributi di villaggio
    int lunghezza=4;
    
//    @Override
//<<<<<<< HEAD
//    public ArrayList<Casella> attacco(Eroe e){
//        
////        ArrayList<Casella> g=new ArrayList<Casella>();
////        g.add(e.getC());
////        Villaggio villaggioD=e.getC().getVillaggio();
////        int col=e.getC().getPosizioneColonna();
////        int r=e.getC().getPosizioneRiga();
//        
//        //prima prova ciclo
////        for (int i=r-1;i<(r+1) && i>(-1) && i<3; i++ ){
////            for (int j=col-1; j>1 && j<(col+1) && j<3 ;j++){
////                Casella c2= new Casella(i,j);
////                g.add(c2);
////                
////            }
////        
////        }
////        for (int i=r;i<=r+1 && i>=r-1;i++){
////             for (int j=col; j<=col+1&& j>=col-1;j++){
//ArrayList<Casella> g=new ArrayList<Casella>();
//        g.add(e.getC());
//        Villaggio villaggioD=e.getC().getVillaggio();
//        int col=e.getC().getPosizioneColonna();
//        int r=e.getC().getPosizioneRiga();
//                int i=r;int j=col;
//                if (i-1>=1) {Casella c1= villaggioD.getCasella(i-1,j);if (i-1>=1 && c1.getEdificio().getStatistica().getVita()!=0 && c1.getEdificio()!=null)
//                 {g.add(c1);}};
//                if (i+1<=4){Casella c2= villaggioD.getCasella(i+1,j); if (i+1<=4 &&c2.getEdificio().getStatistica().getVita()!=0 && c2.getEdificio()!=null)
//                 {g.add(c2);}};
//                if (j-1>=1){Casella c3= villaggioD.getCasella(i,j-1);if (j-1>=1 && c3.getEdificio().getStatistica().getVita()!=0 && c3.getEdificio()!=null)
//                 {g.add(c3);}};
//                if (j+1<=4){Casella c4= villaggioD.getCasella(i,j+1);if (j+1<=4 && c4.getEdificio().getStatistica().getVita()!=0 && c4.getEdificio()!=null)
//                 {g.add(c4);}};
//                
//                 return g;
//             
//             }
        
                
     //       Casella c2=new Casella(col+1,r+1);
        //c2.setPosizioneColonna(col+1);
        //c2.setPosizioneRiga(r+1);
        //g.add(c2);
        
        //System.out.println("attacca Due Posizioni");
        //System.out.println(e.getC().getPosizioneRiga());
//=======
    public ArrayList<Casella> attacco(Eroe e){  
        Villaggio v=e.getC().getVillaggio();
        ArrayList<Casella> g=new ArrayList<Casella>();
        g.add(e.getC());
        int colonna=e.getC().getPosizioneColonna();
        int riga=e.getC().getPosizioneRiga();

        System.out.println("Hellooooooo:Riga: "+riga+" j: "+colonna+" ");
        int cont=0;
        int cont2=0;
        for(int i=riga-1 ;cont<3 && i>=1 && i<=altezza;i++){ 
            for(int j=colonna-1;cont2<3 && j>=1 && j<=lunghezza;j++){
                System.out.println("Riga: "+i+" j: "+j+" ");
                if( i!=riga || j!=colonna){
                Casella c2=v.getCasella(i, j);
                Casella cas=this.verificaVitaEdificio(c2);
                if(cas!=null){
                    g.add(c2);
                    return g;
                }
                }
                
                cont2++;
            }
            cont2=0;
            cont++;        
        }
        if(riga==1 || colonna==1){
            cont=0;
            cont2=0;
            for(int i=riga-1 ;cont<3 && i<=altezza;i++){ 
                for(int j=colonna-1;cont2<3 && j<=lunghezza;j++){
                    System.out.println("OI-Riga: "+i+" j: "+j+" ");
                    if(i>0 && j>0 && (i!=riga || j!=colonna)){
                        System.out.println("OI-Riga: "+i+" j: "+j+" FUCKKKKK");
                        Casella c2=v.getCasella(i, j);
                        Casella cas=this.verificaVitaEdificio(c2);
                        if(cas!=null){
                            g.add(c2);
                            return g;
                        } 
                    }
                    cont2++;
                }
                cont2=0;
                cont++;        
            }
        }       
        
        return g;

    }
//>>>>>>> 767fbf589842e84ccc64dc2a708c3acfc883cf7b

    @Override
    public ArrayList<Casella> attaccoEdificio(Edificio e) {
        return null;
    }
    
     private Casella verificaVitaEdificio(Casella casella){
        Edificio edificio=casella.getEdificio();
                        if(edificio!=null){
                            int vita=casella.getEdificio().getStatistica().getVita();
                            if(vita>0){ 
                                return casella;
                            }
                        } 
        return null;
    }
    
}
