/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class ArciereBuilder extends EroeBuilder{

    
    public ArciereBuilder(){
        super();
        this.reset();
    }
    
    @Override
    public void setSkin(Skin skin) {
        this.eroe.skin=skin;
    }

    @Override
    public void setSkills() {
       this.eroe.stat=new Statistica(15,15,100);

       
    }
    public void reset() {
      	this.eroe = new Eroe(new AttaccaDuePosizioni());
    }

    @Override
    public Eroe build() {
        final Eroe e=this.eroe;
        this.reset();
        return e;
    }
    
    
    
}
