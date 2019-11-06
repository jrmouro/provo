/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo.valuenode;

import edu.ufjf.dcc.provo.NameTermPrefix;
import edu.ufjf.dcc.provo.ValueNode;

/**
 *
 * @author ronaldo
 */
public class NonNegativeIntegerValueNode extends ValueNode{
    
    public NonNegativeIntegerValueNode(Integer value) {
        super(value, null, new NameTermPrefix("nonPositiveInteger","xsd:"));
    }
    
}
