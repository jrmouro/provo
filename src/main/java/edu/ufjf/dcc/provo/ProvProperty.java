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
public class ProvProperty extends Edge{
    
    private final TermPrefix namedProvPrefix;
    public static Integer tabPos = 30;

    public ProvProperty(TermPrefix namedProvPrefix, ProvNode otherNode) {
        super(otherNode, namedProvPrefix.toString());
        this.namedProvPrefix = namedProvPrefix;
    }
    
    public ProvProperty(TermPrefix namedProvPrefix, ProvNode otherNode, String key) {
        super(otherNode, key);
        this.namedProvPrefix = namedProvPrefix;
    }
    
    public ProvProperty(TermPrefix namedProvPrefix) {
        super(namedProvPrefix.toString());
        this.namedProvPrefix = namedProvPrefix;
    }
   

    @Override
    public String toString() {
        
        if(this.getOtherNode() != null)
            
            if(this.getOtherNode() instanceof ValueNode){
                
                return "\t" + this.sAux() + ((ValueNode)this.getOtherNode()).toString() + ";"; 
                
            }else if(this.getOtherNode() instanceof ValueNodeList){
                
                String ret = "\t" + this.namedProvPrefix.toString() + "\n";
                
                int i = 0;
                
                for (; i < this.getOtherNode().size() - 1; i++) {
                    
                    if(this.getOtherNode().get(i) instanceof ValueNode)
                        ret += "\t\t" + this.getOtherNode().get(i).toString() + ",\n";
                    else
                        ret += "\t\t" + ((ProvNode)this.getOtherNode().get(i)).getNameTermPrefix().toString() + ",\n";
                
                }
                
                if(this.getOtherNode().get(i) instanceof ValueNode)
                        ret += "\t\t" + this.getOtherNode().get(i).toString() + ";";
                    else
                        ret += "\t\t" + ((ProvNode)this.getOtherNode().get(i)).getNameTermPrefix().toString() + ";";
                
                return ret;
            
            
            }else{
                return "\t" + this.sAux() + ((ProvNode)this.getOtherNode()).getNameTermPrefix().toString() + ";"; 
            }
        
        return "\t" + this.namedProvPrefix.toString() + ";";
        
    }
       
    
    public String sAux(){
        String ret = this.namedProvPrefix.toString();
        for(int i = this.namedProvPrefix.toString().length(); i < tabPos; i++)
            ret += " ";
        
        return ret;
    }
}
