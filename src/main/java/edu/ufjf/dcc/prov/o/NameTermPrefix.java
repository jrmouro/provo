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
public class NameTermPrefix extends TermPrefix{
    
    final String name;

    public NameTermPrefix(String name, String term, Prefix prefix) {
        super(term, prefix);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + this.name;
    }
    
    
    
}
