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
public class ProvProperty extends Edge{
    
    private final TermPrefix namedProvPrefix;
    public static Integer s = 30;

    public ProvProperty(TermPrefix namedProvPrefix, ProvNode otherNode) {
        super(otherNode);
        this.namedProvPrefix = namedProvPrefix;
    }
    
    public ProvProperty(TermPrefix namedProvPrefix) {
        super();
        this.namedProvPrefix = namedProvPrefix;
    }

    public void setS(Integer s) {
        this.s = s;
    }   

    @Override
    public String toString() {
        if(this.getOtherNode() != null)
            if(this.getOtherNode() instanceof ValueNode)
                return "\t" + this.sAux() + ((ValueNode)this.getOtherNode()).toString() + ";"; 
            else
                return "\t" + this.sAux() + ((ProvNode)this.getOtherNode()).getNameTermPrefix().toString() + ";"; 
        return "\t" + this.namedProvPrefix.toString() + ";";
    }
       
    
    public String sAux(){
        String ret = this.namedProvPrefix.toString();
        for(int i = this.namedProvPrefix.toString().length(); i < s; i++)
            ret += " ";
        
        return ret;
    }
}
