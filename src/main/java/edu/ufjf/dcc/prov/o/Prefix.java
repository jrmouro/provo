/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.prov.o;

import java.net.URL;

/**
 *
 * @author ronaldo
 */
public class Prefix {
    
    private final String prefix;
    private final URL url;

    public Prefix(String prefix, URL url) {
        this.prefix = prefix;
        this.url = url;
    }

    public String getPrefix() {
        return prefix;
    }

    public URL getUrl() {
        return url;
    } 

    @Override
    public String toString() {
        return this.prefix + ":\t<" + this.url.toString() + ">";
    }
    
}
