/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo.valuenode;

import edu.ufjf.dcc.provo.ValueNode;

/**
 *
 * @author ronaldo
 */
public class StringValueNode extends ValueNode{
    
    public StringValueNode(String value) {
        super(value, '\"');
    }
    
}
