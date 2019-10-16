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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo
 */
public class DocWriter {
    
    private Writer writer;

    public DocWriter(OutputStream os) {
        try {
            this.writer = new OutputStreamWriter(os, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void write(Object obj, boolean close){
        this.write(obj.toString(), close);
    }
    
    public void write(Object obj){
        this.write(obj.toString());
    }
    
    public void write(String str){
        this.write(str, false);
    }
    
    public void close(){
        try {
            this.writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void write(String str, boolean close){
        try {
            writer.write(str.toCharArray());
        } catch (IOException ex) {
            Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(close)
            try {
                writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
