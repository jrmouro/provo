/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo;

import java.util.Iterator;

/**
 *
 * @author ronaldo
 */
public abstract class Edge extends Node{
    
    private boolean hasNext = true;
    private Node otherNode = null;
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
    

    public Edge(String key) {
        super(key);
    }
    
    public Edge(Node otherNode, String key) {
        super(key);
        this.otherNode = otherNode;
    }

    public Node getOtherNode() {
        return otherNode;
    }

    public void setOtherNode(Node otherNode) {
        this.otherNode = otherNode;
    }
        
    @Override
    public Iterator<Node> iterator() {
        this.hasNext = true;
        return this.iterator;
    }
    
}
