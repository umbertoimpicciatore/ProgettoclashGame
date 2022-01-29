/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author User
 */
public class Guerriero extends EroeBuilder{
       public Guerriero(){
        super();
        this.reset();
    }
    
    @Override
    public void setSkin(Skin skin) {
        this.eroe.setSkin(skin);
    }

    @Override
    public void setSkills() {
       this.eroe.setStat(new Statistica(15,15,110));

       
    }
    public void reset() {
      	this.eroe = new Eroe(new AttaccaAvanti());
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
    
}
