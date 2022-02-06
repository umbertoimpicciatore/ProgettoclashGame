package com.mycompany.progettoclash;

import com.mycompany.progettoclash.Foundation.PersistanManager;

/**
 *
 * @author User
 */
public class ReginaBuilder extends EroeBuilder {
       public ReginaBuilder(){
        super();
        this.reset();
    }
    
    @Override
    public void setSkin(Skin skin) {
        this.eroe.setSkin(skin);
    }

    @Override
    public void setSkills(Statistica  s) {
       this.eroe.setStat(s);

       
    }
    public void reset() {
      	this.eroe = new Eroe();
    }

    @Override
    public Eroe build() {
        final Eroe e=this.eroe;
        //this.reset();
        return e;
    }

    @Override
    public void setId(int idEroe) {
        this.eroe.setId(idEroe);
    }
    
    
    @Override
    public void setEroeDescrizione() {
        EroeDescrizione desc=PersistanManager.getInstance().getRegina();
        this.eroe.setEroeDescrizione(desc);
    }
    
}
