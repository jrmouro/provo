/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

/**
 *
 * @author ronaldo
 */
public class ProvNode extends Node{
        
    private final NameTermPrefix nameTermPrefix;

    public ProvNode(NameTermPrefix nameTermPrefix) {
        this.nameTermPrefix = nameTermPrefix;
    }

    public NameTermPrefix getNameTermPrefix() {
        return nameTermPrefix;
    }
          
    
    @Override
    public String toString() {
        return this.nameTermPrefix.toString();
    }    
        
}
