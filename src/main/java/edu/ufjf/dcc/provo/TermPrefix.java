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
public class TermPrefix{
    
    private final String term;
    private final Prefix prefix;

    public TermPrefix(String term, Prefix prefix) {
        this.term = term;
        this.prefix = prefix;
    }    
    
    public TermPrefix(String term) {
        this.term = term;
        this.prefix = null;
    }    
    
    
    public String getTerm() {
        return this.term;
    }

    public Prefix getPrefix() {
        return prefix;
    }
    
    @Override
    public String toString() {
        return this.term;
    }
    
}
