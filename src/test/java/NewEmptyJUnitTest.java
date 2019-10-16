/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronaldo
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
    public void hello() {
        int f = 8;
        String a = "";
        String b = "teste teste teste";
        //int na = (a.length() + 8) / 8 * 8;
        int nb = (b.length() + 8) / 8 * 8 + f;
        
        
        for(int i = a.length(); i < nb; i++)
            a += ".";
    
        for(int i = b.length(); i < nb; i++)
            b += ".";
        
        System.out.println(a + "aqui");
        System.out.println(b + "aqui");
    }
}
