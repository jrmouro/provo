/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.io.OutputStream;
import java.util.Iterator;

/**
 *
 * @author ronaldo
 */
public class Prov extends Node{

    public Prov(String key) {
        super(key);
    }
    
    public void print(){
        this.print(System.out);
    }
           
    public void print(OutputStream os){
        this.print(os, 25);
    }
    
    public void print(OutputStream os, int propertyTabPos){
                
        DocPrint dc = new DocPrint(os);
        
        this.prepare(dc, propertyTabPos);
        
        dc.print();
    }
    
    public void prepare(DocPrint dc, int propertyTabPos){
        
        ProvProperty.tabPos = propertyTabPos;
        
        
        for (Iterator<Node> it = this.iterator(); it.hasNext();) {
            Node node = it.next();
            if(node instanceof Prefix)
                dc.add(node);
        }
        
        dc.add("\n\n");
        
        for (Iterator<Node> it = this.iterator(); it.hasNext();) {
            Node node = it.next();
            if(!(node instanceof Prefix)){
                if(node instanceof Prov)
                    ((Prov)node).prepare(dc, propertyTabPos);
                else{                
                    dc.add(node);
                    dc.add("\n\n");
                }
            }
        }
        
        
        
    }
    
    
}
