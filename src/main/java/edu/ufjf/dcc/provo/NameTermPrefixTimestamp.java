/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo;

import java.sql.Timestamp;



/**
 *
 * @author ronaldo
 */
public class NameTermPrefixTimestamp extends NameTermPrefix{

    public NameTermPrefixTimestamp(String name, String term, Prefix prefix) {
        super(name.concat("." + String.valueOf(new Timestamp(System.currentTimeMillis()).getTime())), term, prefix);
    }

    public NameTermPrefixTimestamp(String name, String term) {
        super(name.concat("." + String.valueOf(new Timestamp(System.currentTimeMillis()).getTime())), term);
    }

    public NameTermPrefixTimestamp(String term, NameTermPrefix... nameTermPrefixes) {
        super(term, nameTermPrefixes);
    }
    
}
