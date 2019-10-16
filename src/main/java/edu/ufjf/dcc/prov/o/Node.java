/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo
 */

public class Node implements Iterable{
    
    protected final List<Node> edges = new ArrayList();
    
    public int size(){
        return this.edges.size();
    }
    
    public void add(Node node){
        this.edges.add(node);
    }
    
    @Override
    public Iterator<Node> iterator() {
        return this.edges.iterator();
    }

    @Override
    public String toString() {
        String ret = "";
        for (Node next : this.edges) {
            ret += next.toString() + "\n";
        }
        return ret;
    }
    
}
