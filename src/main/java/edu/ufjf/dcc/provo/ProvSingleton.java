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
public class ProvSingleton extends Prov{
    
    private static ProvSingleton instance = null;

    private ProvSingleton() {
        super("provenance");
    }
    
    public static ProvSingleton getInstance(){
        if(instance == null)
            instance = new ProvSingleton();
        return instance;
    }
    
}
