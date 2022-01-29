package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.Casella;
import com.mycompany.progettoclash.ClashGame;
import com.mycompany.progettoclash.Eroe;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.SelezionePosizionaEroe;
import com.mycompany.progettoclash.Villaggio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewCercaAvversario {
    ClashGame clash;
    
    public void cercaAvversario(Giocatore giocatoreA){
    

        String s="Immetti 1 per iniziare battaglia oppure un numero maggiore di 1 per annullare";
        int ris=this.inserisci(s);
        if(ris==1){
            // clash=new ClashGame(giocatoreA);
           // clash.cercaAvversario();
            giocatoreA.cercaAvversario();
        }
        else{
            return;
        }
    
    }
    
    public void conferma(Giocatore giocatoreD,Giocatore giocatoreA){
        this.visualizzaVillaggio(giocatoreD.getVillaggio());
        String s="Immetti numero positivo: 1 per confermare, 2 per cercare un altro avversaio, altro per annullare ";
        int ris=this.inserisci(s);
         switch(ris) {
             
            case 1: 
                this.mostraSelezionaPosizionaEroe(giocatoreA,giocatoreD,false);
                break;
            
            case 2: 
                giocatoreA.cercaAvversario();
                break;

            default: break;
            }
    }
    
    public void mostraSelezionaPosizionaEroe(Giocatore giocatoreA,Giocatore giocatoreD,boolean errore){
        
        ArrayList<Eroe> eroiA=giocatoreA.getEroi();//implementa
        //if(eroiA)
        for(int i=0;i<eroiA.size();i++){
            System.out.println("Arciere id 10");
        }
   
        if(errore==true){
            System.out.println("Riga/Colonna/Quantita o idEroe immesso sbagliato");
        }
        
            String s="Immetti numero riga edificio da selezionare: ";
            int riga=this.inserisci(s);
            s="Immetti numero colonna edificio da selezionare: ";
            int colonna=this.inserisci(s);
            s="Immetti idEroe da selezionare: ";
            int idEroe=this.inserisci(s);
            s="Immetti quantità eroe da selezionare: ";
            int quantita=this.inserisci(s);
            System.out.println(" ");
            SelezionePosizionaEroe sel= new SelezionePosizionaEroe();
            sel.selezionaPosizionaEroe(riga,colonna,idEroe,quantita,giocatoreA,giocatoreD);
        
        }
    
    public void iniziaBattaglia(ClashGame clash,boolean eroiFiniti){
        int iniziaBattaglia;
        if(!eroiFiniti){
            String s="Vuoi iniziare la battaglia? Inserisci 1 per confermare altrimenti un numero maggiore di 1 per continuare a immettere eroi  ";
            iniziaBattaglia=this.inserisci(s);
        }
        else{
            iniziaBattaglia=1;
        }
        

        if (iniziaBattaglia==1){
            System.out.println("BATTAGLIA INIZIATA");
            System.out.println("");
            clash.iniziaBattaglia();
        }
        else{
            this.mostraSelezionaPosizionaEroe(clash.getGiocatoreA(),clash.getGiocatoreD(), false);
        }        
    
    }
    
    private int inserisci(String strDaVisualizzare){
        
        int var=0;
        Scanner sc=new Scanner(System.in);
        do {
             System.out.println(strDaVisualizzare);
             while (!sc.hasNextInt()) {
                 System.out.println("Errore, immetti un numero");
                 sc.next(); 
             }
             var = sc.nextInt();
         } while (var <= 0);
         return var;
    }
    
      public void visualizzaVillaggio(Villaggio villaggioD){
          StringBuilder value=new StringBuilder("");
          String s="";
        for (int i=1;i<=villaggioD.getAltezza();i++){
            s="";
            for (int j=1;j<=villaggioD.getLarghezza();j++){
                Casella c=villaggioD.getCasella(i, j); 
                s="Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ";
                //value.append(s);
                //System.out.print("Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ");
                if(c.getEdificio()!=null){
                    s=s+"Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ";
                    //value.append("Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ");
                    //System.out.print("Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ");

                }
                ArrayList<Eroe> er = c.getListaEroiA();
                for (int k=0;k<er.size();k++){
                    s=s+"IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita()+" ";
                    //value.append("IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita());
                    //System.out.print("IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita());
                    
                }
               // value.toString();
               System.out.print(s);
                System.out.print("     ");
                
            }
            System.out.println();
        }
        System.out.println("");

    }   
}
