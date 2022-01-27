
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.view.ViewCercaAvversario;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Giocatore {
    private int livello;
    private Accampamento Accampamento;//vedere LARMAN

    
    private String nome;
    private Villaggio villaggio;

    public Villaggio getVillaggio() {
        return villaggio;
    }

    public Accampamento getAccampamento() {
        return Accampamento;
    }

    public void setAccampamento(Accampamento Accampamento) {
        this.Accampamento = Accampamento;
    }

    
    public void setVillaggio(Villaggio v) {
        this.villaggio = v;
    }
    
    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Eroe> getEroi(){
        return this.Accampamento.getListaEroiGiocatore();
        /* Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        //guerriero.setC(c);
        //guerriero.getModA().attacco(guerriero);
       //guerriero.attacca();
         Eroe arciere=new Arciere(new AttaccaDuePosizioni(),2);
      // arciere.attacca();
      
        //arciere.setC(c);
        //guerriero.setC(c);
        ArrayList<Eroe> eroi = new ArrayList<Eroe>();
        eroi.add(arciere);
        eroi.add(guerriero);
        return eroi;//da implementare*/
    }
    
   /* public void posizionaEroe(int riga,int colonna,ArrayList<Eroe> listaEroi){
        Casella c=clash.getGiocatoreD().getVillaggio().getCasella(riga, colonna);
        c.addEroi(listaEroi);
        
    }*/
    
    public void cercaAvversario(){
        
        TrovaAvversario t=new TrovaAvversario();
        Giocatore giocatoreD=t.getAvversario(this);
        
        ViewCercaAvversario view=new ViewCercaAvversario();//si può fare dentro il controller?
        view.conferma(giocatoreD,this);
        
        
        //o confermo, o cerco un altro, o annullo
        
        //ora bisogna far visualizzare il villaggio difensore e deve partire la conferma per attaccare questo giocatore
        //ma dove la richiamo la view e come faccio?
        
    }
    
    
}
