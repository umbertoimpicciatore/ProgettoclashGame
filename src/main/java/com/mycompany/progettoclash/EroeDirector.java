
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class EroeDirector {
    

    
    public Eroe createEroe(EroeBuilder eroeBuilder){
        
       eroeBuilder.setSkills();
       eroeBuilder.setSkin(new SkinBase());
       return eroeBuilder.build();
    }
    
    public Eroe createEroePotenziato(EroeBuilder eroeBuilder){
        
        eroeBuilder.setSkills();
        eroeBuilder.setSkin(new SkinPotenziata());
        return eroeBuilder.build();
        
    }
}
