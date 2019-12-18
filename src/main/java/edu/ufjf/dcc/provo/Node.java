/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */

public class Node implements Iterable{
    
    protected final String key;
    protected final List<Node> children = new ArrayList();

    public Node(String key) {
        this.key = key;
    } 
    
    public Node() {
        this.key = null;
    } 

    public String getKey() {
        return key;
    }
    
    public int size(){
        return this.children.size();
    }
    
    public Node get(int index){
        return this.children.get(index);
    }
    
    final public void add(Node node){
        this.children.add(node);
    }
    
    public Node getChildByKey(String key){
        
        for (Node node : this.children) {
            if(node.key.equals(key))
                return node;
        }
        
        return null;
        
    }
    
    @Override
    public Iterator<Node> iterator() {
        return this.children.iterator();
    }

    @Override
    public String toString() {
        String ret = "";
        for (Node next : this.children) {
            ret += next.toString() + "\n";
        }
        return ret;
    }
    
}
