/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.ufjf.dcc.prov.o.NameTermPrefix;
import edu.ufjf.dcc.prov.o.TermPrefix;
import edu.ufjf.dcc.prov.o.Node;
import edu.ufjf.dcc.prov.o.ProvNode;
import edu.ufjf.dcc.prov.o.ProvoClassType;
import edu.ufjf.dcc.prov.o.Prefix;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
    public void test() throws MalformedURLException, IOException {

        Prefix pp = new Prefix("prov", new URL("http://www.w3.org/ns/prov#"));
        TermPrefix npp = new NameTermPrefix(ProvoClassType.Entity.name(), "a prov", pp);
        Node n = new ProvNode((NameTermPrefix) npp);

        
        
        n.write(System.out);
        n.write(new FileOutputStream("input_text.txt"));

    }
}
