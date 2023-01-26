
package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class MatchMakingBasedOnLvEroiStrategy implements MatchMakingStrategy{
    

    @Override
    public Giocatore getAvversario(Giocatore g) {
        ArrayList<Giocatore> lista=PersistanManager.getInstance().getGiocatori();
        if(lista.size()==1){
            return lista.get(0);
        }
        else if(lista.size()>1){
            int l=g.getSommaLivelloEroi();
            for (int i=0;i<lista.size();i++){
                Giocatore avversario=lista.get(i);
                int l2=avversario.getSommaLivelloEroi();
            if (l2==l){
                return avversario;
            }
        }
        }
    return null;
    }
}
    

