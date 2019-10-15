/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.util.Iterator;

/**
 *
 * @author ronaldo
 */
public abstract class Edge implements Node{
    
    private boolean hasNext = true;
    private final Node otherNode;
    private final Iterator<Node> iterator = 
            new Iterator(){
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Object next() {
                hasNext = false;
                return otherNode;
            }
            
        };
    

    public Edge(Node otherNode) {
        this.otherNode = otherNode;
    }

    public Node getOtherNode() {
        return otherNode;
    }
    
    
    @Override
    public Iterator<Node> iterator() {
        this.hasNext = true;
        return this.iterator;
    }
    
}
