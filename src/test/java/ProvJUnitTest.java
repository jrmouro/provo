/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.ufjf.dcc.prov.o.NameTermPrefix;
import edu.ufjf.dcc.prov.o.Prefix;
import edu.ufjf.dcc.prov.o.ProvSingleton;
import edu.ufjf.dcc.prov.o.ProvNode;
import edu.ufjf.dcc.prov.o.ProvProperty;
import edu.ufjf.dcc.prov.o.ValueNode;
import edu.ufjf.dcc.prov.o.ValueNodeList;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class ProvJUnitTest {
    
    public ProvJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() throws MalformedURLException {
    
        ProvSingleton prov = ProvSingleton.getInstance();
        
        prov.add(new Prefix("xsd:", new URL("http://www.w3.org/2001/XMLSchema#")));
        prov.add(new Prefix("foaf:", new URL("http://xmlns.com/foaf/0.1/")));
        prov.add(new Prefix("prov:", new URL("http://www.w3.org/ns/prov#")));
        prov.add(new Prefix("xlink:", new URL("http://www.w3.org/1999/xlink")));
        prov.add(new Prefix(":", new URL("http://example.org#")));
        
        
        ProvNode ufjf = new ProvNode(new NameTermPrefix("ufjf",":")); 
        ufjf.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Organization","foaf:"), new NameTermPrefix("agent","prov:"))));
        ufjf.add(new ProvProperty(new NameTermPrefix("name", "foaf:"), new ValueNode("Universidade Federal de Juiz de Fora",'\"')));
        ufjf.add(new ProvProperty(new NameTermPrefix("homepage", "foaf:"), new ValueNode("https://www2.ufjf.br/ufjf/",'\"')));
        prov.add(ufjf);
        
        ProvNode user = new ProvNode(new NameTermPrefix("User",":"));  
        user.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Person","foaf:"), new NameTermPrefix("Agent","prov:"))));
        user.add(new ProvProperty(new NameTermPrefix("name", "foaf:"), new ValueNode("Jairo F. de Sousa",'\"')));
        user.add(new ProvProperty(new NameTermPrefix("mbox", "foaf:"), new ValueNode("jairo.souza@ice.ufjf.br",'<', '>')));
        user.add(new ProvProperty(new NameTermPrefix("actedOnBehalfOf", "prov:"), ufjf));
        prov.add(user);        
        
        ProvNode o1 = new ProvNode(new NameTermPrefix("ontology1",":"));  
        o1.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));
        o1.add(new ProvProperty(new NameTermPrefix("href", "xlink:"), new ValueNode("http://oaei.ontologymatching.org/2007/benchmarks/101/onto.rdf#",'\"')));
        prov.add(o1);        
        
        ProvNode o2 = new ProvNode(new NameTermPrefix("ontology2",":"));  
        o2.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));
        o2.add(new ProvProperty(new NameTermPrefix("href", "xlink:"), new ValueNode("http://oaei.ontologymatching.org/2007/benchmarks/101/onto.rdf#",'\"')));
        prov.add(o2);        
        
        ProvNode exp = new ProvNode(new NameTermPrefix("ExperimentDefinition",":"));
        exp.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        exp.add(new ProvProperty(new NameTermPrefix("used", "prov:"), o1));
        exp.add(new ProvProperty(new NameTermPrefix("used", "prov:"), o2));
        exp.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), user));
        exp.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        exp.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        prov.add(exp);
                
        ProvNode preAlignment = new ProvNode(new NameTermPrefix("PreAlignment",":"));  
        preAlignment.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));        
        preAlignment.add(new ProvProperty(new NameTermPrefix("href", "xlink:"), new ValueNode("http://oaei.ontologymatching.org/2007/benchmarks/101/refalign.rdf#",'\"')));
        prov.add(preAlignment);        
        
        ProvNode popIni = new ProvNode(new NameTermPrefix("ag.populacao.inicial",":"));  
        popIni.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:")))); 
        popIni.add(new ProvProperty(new NameTermPrefix("value", "prov:"), new ValueNode(100, null, new NameTermPrefix("nonPositiveInteger","xsd:"))));
        prov.add(popIni);
        
        ProvNode ger = new ProvNode(new NameTermPrefix("ag.geracoes",":"));  
        ger.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:")))); 
        ger.add(new ProvProperty(new NameTermPrefix("value", "prov:"), new ValueNode(300, null, new NameTermPrefix("nonPositiveInteger","xsd:"))));
        prov.add(ger);
        
        ValueNodeList vnl = new ValueNodeList("OptimizationParameters");
        vnl.add(popIni);
        vnl.add(ger);        
        
        ProvNode opl = new ProvNode(new NameTermPrefix("OptimizationParametersList",":"));  
        opl.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Collection","prov:"))));   
        opl.add(new ProvProperty(new NameTermPrefix("hadMember", "prov:"), vnl));        
        prov.add(opl);
        
        ProvNode rmh = new ProvNode(new NameTermPrefix("ResultingMetaHeuristic",":"));  
        rmh.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Agent","prov:"))));
        prov.add(rmh);
        
        ProvNode of = new ProvNode(new NameTermPrefix("ObjectiveFunction",":"));  
        of.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Agent","prov:"))));
        of.add(new ProvProperty(new NameTermPrefix("actedOnBehalfOf", "prov:"), rmh));
        prov.add(of);
        
        ProvNode wc = new ProvNode(new NameTermPrefix("WeightCalculation",":"));
        wc.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        wc.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), rmh));
        wc.add(new ProvProperty(new NameTermPrefix("used", "prov:"), preAlignment));
        wc.add(new ProvProperty(new NameTermPrefix("used", "prov:"), opl));
        prov.add(wc);        
        
        ProvNode eval = new ProvNode(new NameTermPrefix("Evaluator",":"));  
        eval.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Agent","prov:"))));
        prov.add(eval);
        
        ProvNode sMatrix = new ProvNode(new NameTermPrefix("SimilarityMatrix",":"));  
        sMatrix.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));
        prov.add(sMatrix);
        
        ProvNode aFile = new ProvNode(new NameTermPrefix("AlignmentFile",":"));  
        aFile.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));
        prov.add(aFile);
        
        ProvNode refBase = new ProvNode(new NameTermPrefix("ReferenceBase",":"));  
        refBase.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Entity","prov:"))));
        prov.add(refBase);
        
        ProvNode aEval = new ProvNode(new NameTermPrefix("AlignmentEvaluation",":"));
        aEval.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        aEval.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), eval));
        aEval.add(new ProvProperty(new NameTermPrefix("used", "prov:"), sMatrix));
        aEval.add(new ProvProperty(new NameTermPrefix("used", "prov:"), aFile));
        aEval.add(new ProvProperty(new NameTermPrefix("used", "prov:"), refBase));
        aEval.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        aEval.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        prov.add(aEval);        
        
        ProvNode result = new ProvNode(new NameTermPrefix("ResultsGeneration",":"));
        result.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        result.add(new ProvProperty(new NameTermPrefix("wasInformedBy", "prov:"), aEval));
        result.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        result.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        prov.add(result);
        
        ProvNode bWeights = new ProvNode(new NameTermPrefix("ReferenceBase",":"));  
        bWeights.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Collection","prov:"))));
        bWeights.add(new ProvProperty(new NameTermPrefix("wasGeneratedBy", "prov:"), wc));
        prov.add(bWeights);
        
        /*ProvNode weights = new ProvNode(new NameTermPrefix("Weights",":"));  
        weights.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Collection","prov:"))));
        weights.add(new ProvProperty(new NameTermPrefix("wasGeneratedBy", "prov:"), wc));
        prov.add(weights);*/
        
        ProvNode sFunction = new ProvNode(new NameTermPrefix("SimilarityFunction",":"));  
        sFunction.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Agent","prov:"))));
        prov.add(sFunction);
        
        ProvNode mCalc = new ProvNode(new NameTermPrefix("SimilarityMatrixCalculation",":"));
        mCalc.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        mCalc.add(new ProvProperty(new NameTermPrefix("used", "prov:"), bWeights));
        mCalc.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), sFunction));
        mCalc.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        mCalc.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        prov.add(result);
        
        ProvNode aAlg = new ProvNode(new NameTermPrefix("AlignmentAlgorithm",":"));  
        aAlg.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Agent","prov:"))));
        prov.add(aAlg);
        
        ProvNode aDef = new ProvNode(new NameTermPrefix("AlignmentDefinition",":"));
        aDef.add(new ProvProperty(new NameTermPrefix("a ", new NameTermPrefix("Activity","prov:"))));
        aDef.add(new ProvProperty(new NameTermPrefix("wasInformedBy", "prov:"), mCalc));
        aDef.add(new ProvProperty(new NameTermPrefix("wasAssociatedWith", "prov:"), aAlg));
        aDef.add(new ProvProperty(new NameTermPrefix("startedAtTime", "prov:"), new ValueNode("2011-07-14T01:01:01Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        aDef.add(new ProvProperty(new NameTermPrefix("endedAtTime", "prov:"), new ValueNode("2011-07-14T02:02:02Z",'\"', new NameTermPrefix("dateTime","xsd:"))));
        prov.add(aDef);
        
        
        
        prov.print();
    
    }
}
