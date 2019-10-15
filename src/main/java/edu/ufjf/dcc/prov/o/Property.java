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
public class Property extends Edge{
    
    private final TermPrefix namedProvPrefix;

    public Property(TermPrefix namedProvPrefix, Node otherNode) {
        super(otherNode);
        this.namedProvPrefix = namedProvPrefix;
    }

    @Override
    public String toString() {
        if(this.getOtherNode() != null)
            return this.namedProvPrefix.toString() + "\t" + this.getOtherNode().toString(); 
        return this.namedProvPrefix.toString();
    }
        
}
