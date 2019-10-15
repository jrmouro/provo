/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class Prov implements Node{
    
    private final List<Node> edges = new ArrayList();
    private final TermPrefix termPrefix;

    public Prov(NameTermPrefix termPrefix) {
        this.termPrefix = termPrefix;
    }
      
    @Override
    public Iterator<Node> iterator() {
        return this.edges.iterator();
    }

    @Override
    public String toString() {
        return this.termPrefix.toString();
    }    
        
}
