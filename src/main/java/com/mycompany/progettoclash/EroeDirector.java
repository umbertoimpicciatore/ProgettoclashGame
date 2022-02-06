
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class EroeDirector {
    
    private EroeBuilder eroeBuilder;

    public EroeDirector(EroeBuilder eroeBuilder) {
        this.eroeBuilder = eroeBuilder;
    }
    
    
    public Eroe createEroe(Statistica s){
        
       this.eroeBuilder.setSkills( s);
       this.eroeBuilder.setSkin(new SkinBase());
       return eroeBuilder.build();
    }
    
    public Eroe createEroePotenziato( Statistica s){
        
        this.eroeBuilder.setSkills(s);
        this.eroeBuilder.setSkin(new SkinPotenziata());
        return eroeBuilder.build();
        
    }

    public Eroe createEroe2( Statistica s,Skin skin,int id){
        
        this.eroeBuilder.setSkills(s);
        this.eroeBuilder.setSkin(skin);
        this.eroeBuilder.setId(id);
        return eroeBuilder.build();
        
    }
}
