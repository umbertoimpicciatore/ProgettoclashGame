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
public abstract class EroeBuilder {
    
    protected Eroe eroe;
    public abstract void setId(int idEroe);
    public abstract void setSkin(Skin skin);
    public abstract void setSkills(Statistica s);
    public abstract Eroe build();
    
}
