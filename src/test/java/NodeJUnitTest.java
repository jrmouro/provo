/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.ufjf.dcc.prov.o.NameTermPrefix;
import edu.ufjf.dcc.prov.o.TermPrefix;
import edu.ufjf.dcc.prov.o.Node;
import edu.ufjf.dcc.prov.o.Prov;
import edu.ufjf.dcc.prov.o.ProvClass;
import edu.ufjf.dcc.prov.o.Prefix;
import java.net.MalformedURLException;
import java.net.URL;


import org.junit.Test;
/**
 *
 * @author ronaldo
 */
public class NodeJUnitTest {
    
    public NodeJUnitTest() {
    }
    
    

    @Test
    public void test() throws MalformedURLException {
        
        Prefix pp = new Prefix("prov",new URL("http://www.w3.org/ns/prov#"));
        TermPrefix npp = new NameTermPrefix(ProvClass.Entity.name(),"a prov", pp);
        Node n = new Prov((NameTermPrefix) npp);
        
        System.out.println(n);
        System.out.println(pp);
        System.out.println(npp);
    
    }
}
