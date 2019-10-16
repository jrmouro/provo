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
        
    protected final NameTermPrefix nameTermPrefix;

    public ProvNode(NameTermPrefix nameTermPrefix) {
        this.nameTermPrefix = nameTermPrefix;
    }

    public NameTermPrefix getNameTermPrefix() {
        return nameTermPrefix;
    }
        
    @Override
    public String toString() {
        
        String ret = this.nameTermPrefix.toString() + "\n";
        
        if(this.edges.size() > 0){            
            for (Node edge : this.edges) {
                ret += edge.toString() + "\n";
            }
            return ret + ".";
        }
        
        return ret + ".";
    }    
        
}
