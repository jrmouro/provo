/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo;

/**
 *
 * @author ronaldo
 */
public class ProvNode extends Node{
        
    protected final NameTermPrefix nameTermPrefix;

    public ProvNode(NameTermPrefix nameTermPrefix, String key) {
        super(key);
        this.nameTermPrefix = nameTermPrefix;
    }
    
    public ProvNode(NameTermPrefix nameTermPrefix) {
        super(nameTermPrefix.toString());
        this.nameTermPrefix = nameTermPrefix;
    }

    public NameTermPrefix getNameTermPrefix() {
        return nameTermPrefix;
    }
        
    @Override
    public String toString() {
        
        if(this.nameTermPrefix == null)
            return "null";
        
        String ret = this.nameTermPrefix.toString() + "\n";
        
        if(this.children.size() > 0){            
            for (Node edge : this.children) {
                ret += edge.toString() + "\n";
            }
            return ret + ".";
        }
        
        return ret + ".";
    }    
        
}
