package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.Casella;
import com.mycompany.progettoclash.Eroe;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import com.mycompany.progettoclash.Risorsa;
import com.mycompany.progettoclash.CAttacca;
import com.mycompany.progettoclash.Villaggio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewAttacco {
    
    public void cercaAvversario(Giocatore giocatoreA){
    

        String s="Immetti 1 per iniziare battaglia oppure un numero maggiore di 1 per annullare";
        int ris=this.inserisci(s);
        if(ris==1){
            CAttacca attacca=new CAttacca();
            attacca.cercaAvversario(giocatoreA);
        }
        else{
            ViewIniziale view=new ViewIniziale();
            view.selezionaOperazione(giocatoreA,false);
        }
    
    }
    
    public void conferma(Giocatore giocatoreD,Giocatore giocatoreA,int idBattaglia){
        System.out.println("VILLAGGIO AVVERSARIO: ");
        this.visualizzaVillaggio(giocatoreD.getVillaggio());
        String s="Immetti numero positivo: 1 per confermare, 2 per cercare un altro avversaio, altro per annullare ";
        int ris=this.inserisci(s);
        CAttacca attacca;
         switch(ris) {
            case 1: 
                attacca=new CAttacca();
                attacca.conferma(idBattaglia);
                break;
            
            case 2: 
                attacca=new CAttacca();
                attacca.cercaAvversario(giocatoreA);
                break;

            default:
                ViewIniziale view=new ViewIniziale();
                view.selezionaOperazione(giocatoreA,false);
                break;
            }
    }
    
    public void mostraSelezionaPosizionaEroe(boolean errore,HashMap<EroeDescrizione,Integer> map,int idBattaglia){
        for (EroeDescrizione name: map.keySet()) {
            String key = name.toString2();
            int value = map.get(name);
            System.out.println(key + " quantitaDisponibile: " + value);
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
            CAttacca attacca= new CAttacca();
            attacca.selezionaPosizionaEroe(riga,colonna,idEroe,quantita,idBattaglia);
        
        }
    
    public void iniziaBattaglia(boolean eroiFiniti,HashMap<EroeDescrizione,Integer> map,int idBattaglia){
        int iniziaBattaglia;
        if(!eroiFiniti){
            String s="Vuoi iniziare la battaglia? Inserisci 1 per confermare altrimenti un numero maggiore di 1 per continuare a immettere eroi  ";
            iniziaBattaglia=this.inserisci(s);
        }
        else{
            iniziaBattaglia=1;
        }
        
        if (iniziaBattaglia==1){
            //System.out.println("BATTAGLIA INIZIATA");
            System.out.println("");
            CAttacca attacca=new CAttacca();
            attacca.iniziaBattaglia(idBattaglia);
        }
        else{
            this.mostraSelezionaPosizionaEroe( false,map, idBattaglia);
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
        String s="";
        for (int i=1;i<=villaggioD.getAltezza();i++){
            s="";
            for (int j=1;j<=villaggioD.getLarghezza();j++){
                Casella c=villaggioD.getCasella(i, j); 
                s="Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ";
                if(c.getEdificio()!=null){
                    s=s+"Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ";
                }
                ArrayList<Eroe> er = c.getListaEroiA();
                for (int k=0;k<er.size();k++){
                    s=s+"IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita();                    
                }
                System.out.print(s);
                System.out.print("     ");
            }
            System.out.println();
        }
        System.out.println("");
    }  
    
    public void mostraRisorseRubate(ArrayList<Risorsa> risorse){
        if(risorse!=null){
            for (int i=0;i<risorse.size();i++){
                System.out.println("RISORSA OTTENUTA: "+risorse.get(i).toString());
            }
        }
        else{
            //for (int i=0;i<risorse.size();i++){
                System.out.println("Nessuna risorsa ottenuta");
            //}
        }

    
    }
}
