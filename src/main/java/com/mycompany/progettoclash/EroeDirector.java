
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class EroeDirector {
    

    
    public Eroe createEroe(EroeBuilder eroeBuilder,Statistica s){
        
       eroeBuilder.setSkills( s);
       eroeBuilder.setSkin(new SkinBase());
       return eroeBuilder.build();
    }
    
    public Eroe createEroePotenziato(EroeBuilder eroeBuilder, Statistica s){
        
        eroeBuilder.setSkills(s);
        eroeBuilder.setSkin(new SkinPotenziata());
        return eroeBuilder.build();
        
    }
    public Eroe createEroe2(EroeBuilder eroeBuilder, Statistica s,Skin skin){
        
        eroeBuilder.setSkills(s);
        eroeBuilder.setSkin(skin);
        return eroeBuilder.build();
        
    }
}
