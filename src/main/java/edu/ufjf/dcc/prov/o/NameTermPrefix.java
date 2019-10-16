/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class NameTermPrefix extends TermPrefix{
    
    private final String name;
    private final List<NameTermPrefix> nameTermPrefixes = new ArrayList();

    public NameTermPrefix(String name, String term, Prefix prefix) {
        super(term, prefix);
        this.name = name;
    }
    
    public NameTermPrefix(String name, String term) {
        super(term);
        this.name = name;
    }
    
    public NameTermPrefix(String term, NameTermPrefix... nameTermPrefixes) {
        super(term);
        this.name = null;
        for (NameTermPrefix nameTermPrefixe : nameTermPrefixes) {
            this.nameTermPrefixes.add(nameTermPrefixe);
        }
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {        
        if(this.nameTermPrefixes.size() > 0){
            String ret = super.toString();
            int i = 0;
            for (; i < this.nameTermPrefixes.size() - 1; i++) {
                ret += this.nameTermPrefixes.get(i).toString() + ", ";
            }
            ret += this.nameTermPrefixes.get(i).toString();
            return ret;
        }
        return super.toString() + this.name;
    }
    
}
