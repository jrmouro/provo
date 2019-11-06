/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufjf.dcc.provo.valuenode;

import edu.ufjf.dcc.provo.NameTermPrefix;
import edu.ufjf.dcc.provo.ValueNode;
import java.time.LocalDateTime;

/**
 *
 * @author ronaldo
 */
public class DateTimeValueNode extends ValueNode{
    
    public DateTimeValueNode(LocalDateTime datetime) {
        super(datetime.toString(),'\"', new NameTermPrefix("dateTime","xsd:"));
    }
    
}
