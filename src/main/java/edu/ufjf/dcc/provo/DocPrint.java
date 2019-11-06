/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class DocPrint implements Iterable<Object>{
    
    private final List<Object> objects = new ArrayList();
    private OutputStream os;

    public DocPrint(OutputStream os) {
        this.os = os;
    }
    
    public void add(Object obj){
        this.objects.add(obj);
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }    
    
    public DocPrint() {
        this.os = System.out;
    }
    
    public void print(){
        DocWriter w = new DocWriter(this.os);
        for (Object object : this.objects) {
            w.write(object);
        }
        w.close();
    }    

    @Override
    public Iterator<Object> iterator() {
        return this.objects.iterator();
    }
    
}
