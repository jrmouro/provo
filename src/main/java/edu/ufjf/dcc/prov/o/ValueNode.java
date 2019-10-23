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
public class ValueNode extends ProvNode{
    
    final private Object value;
    final private Character c1, c2;
    
    public ValueNode(Object value, Character c,  NameTermPrefix nameTermPrefix, String key) {
        super(nameTermPrefix, key);
        this.value = value;
        this.c1 = this.c2 = c;
    }
    
    public ValueNode(Object value, Character c, String key) {
        super(null, key);
        this.value = value;
        this.c1 = this.c2 = c;
    }
    
    public ValueNode(Object value, Character c1,  Character c2, NameTermPrefix nameTermPrefix, String key) {
        super(nameTermPrefix, key);
        this.value = value;
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public ValueNode(Object value, Character c1,  Character c2, String key) {
        super(null, key);
        this.value = value;
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public ValueNode(Object value, Character c,  NameTermPrefix nameTermPrefix) {
        super(nameTermPrefix, value.toString());
        this.value = value;
        this.c1 = this.c2 = c;
    }
    
    public ValueNode(Object value, Character c) {
        super(null, value.toString());
        this.value = value;
        this.c1 = this.c2 = c;
    }
    
    public ValueNode(Object value, Character c1,  Character c2, NameTermPrefix nameTermPrefix) {
        super(nameTermPrefix, value.toString());
        this.value = value;
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public ValueNode(Object value, Character c1,  Character c2) {
        super(null, value.toString());
        this.value = value;
        this.c1 = c1;
        this.c2 = c2;
    }

    public Object getValue() {
        return value;
    }

    
    
    
    
    @Override
    public String toString() {
        
        String ret = "";
        
        if(this.c1 != null)
            ret = String.valueOf(this.c1) + this.value.toString() + String.valueOf(this.c2);
        else
            ret = this.value.toString();
        
        if(this.nameTermPrefix != null)
            ret += "^^" + this.nameTermPrefix.toString();
        
        return ret;
    }    
        
    
    
}
