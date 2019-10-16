/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.ufjf.dcc.prov.o.DocPrint;
import edu.ufjf.dcc.prov.o.Prefix;
import edu.ufjf.dcc.prov.o.NameTermPrefix;
import edu.ufjf.dcc.prov.o.ProvNode;
import edu.ufjf.dcc.prov.o.ProvProperty;
import edu.ufjf.dcc.prov.o.ValueNode;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class NodeJUnitTest {

    public NodeJUnitTest(){}

    @Test
    public void test() throws MalformedURLException, IOException {
        
        DocPrint dc = new DocPrint();
        ProvProperty.s = 25;
        
        dc.add(new Prefix("xsd:", new URL("http://www.w3.org/2001/XMLSchema#")));
        dc.add(new Prefix("foaf:", new URL("http://xmlns.com/foaf/0.1/")));
        dc.add(new Prefix("prov:", new URL("http://www.w3.org/ns/prov#")));
        dc.add(new Prefix(":", new URL("http://example.org#")));
        dc.add("\n\n");
        
        ProvNode ufjf = new ProvNode(new NameTermPrefix("ufjf",":")); 
        ufjf.add(new ProvProperty(new NameTermPrefix("a ",new NameTermPrefix("Organization","foaf:"), new NameTermPrefix("agent","prov:"))));
        ufjf.add(new ProvProperty(new NameTermPrefix("name", "foaf:"), new ValueNode("Universidade Federal de Juiz de Fora",'\"')));
        ufjf.add(new ProvProperty(new NameTermPrefix("homepage", "foaf:"), new ValueNode("https://www2.ufjf.br/ufjf/",'\"')));
        dc.add(ufjf);
        dc.add("\n\n");
        
        ProvNode user = new ProvNode(new NameTermPrefix("User",":"));  
        user.add(new ProvProperty(new NameTermPrefix("a ",new NameTermPrefix("Person","foaf:"), new NameTermPrefix("Agent","prov:"))));
        user.add(new ProvProperty(new NameTermPrefix("name", "foaf:"), new ValueNode("Jairo F. de Sousa",'\"')));
        user.add(new ProvProperty(new NameTermPrefix("mbox", "foaf:"), new ValueNode("jairo.souza@ice.ufjf.br",'<', '>')));
        user.add(new ProvProperty(new NameTermPrefix("actedOnBehalfOf", "prov:"), ufjf));
        dc.add(user);
        dc.add("\n\n");
        
        ProvNode o1 = new ProvNode(new NameTermPrefix("ontology1",":"));  
        o1.add(new ProvProperty(new NameTermPrefix("a ",new NameTermPrefix("Entity","prov:"))));
        o1.add(new ProvProperty(new NameTermPrefix("href", "xlink:"), new ValueNode("http://oaei.ontologymatching.org/2007/benchmarks/101/onto.rdf#",'\"')));
        dc.add(o1);
        dc.add("\n\n");
        
        ProvNode o2 = new ProvNode(new NameTermPrefix("ontology2",":"));  
        o2.add(new ProvProperty(new NameTermPrefix("a ",new NameTermPrefix("Entity","prov:"))));
        o2.add(new ProvProperty(new NameTermPrefix("href", "xlink:"), new ValueNode("http://oaei.ontologymatching.org/2007/benchmarks/101/onto.rdf#",'\"')));
        dc.add(o2);
        dc.add("\n\n");
        
        ProvNode exp = new ProvNode(new NameTermPrefix("ExperimentDefinition",":"));
        exp.add(new ProvProperty(new NameTermPrefix("a ",new NameTermPrefix("Activity","prov:"))));
        exp.add(new ProvProperty(new NameTermPrefix("used", "prov:"), o1));
        exp.add(new ProvProperty(new NameTermPrefix("used", "prov:"), o2));
        exp.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), user));
        exp.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        exp.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        
        dc.add(exp);
        dc.add("\n\n");
        
        dc.print();
        
        OutputStream osf = new FileOutputStream("prov.txt");
       
        dc.setOs(osf);
        
        dc.print();

    }
}
