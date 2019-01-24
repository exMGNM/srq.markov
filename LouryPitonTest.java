/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfranc.com;


import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 *
 * @author ap652975
 */
public class LouryPitonTest {
    
        public LouryPitonTest(){
        }
    
    	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

    /**
     * Test of readFile method when the file is empty, of class Markov.
     */
    @Test
    public void testReadFileOnEmpty() {
        System.out.println("readFile");
        String path = "textRead1.txt";
        Markov instance = new Markov();
        instance.readFile(path);
        int result = instance.couples.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of readFile method, of class Markov.
     * Le fichier textRead2.txt a pour contenu : "esirem ecole facile"
     * On vérifie que le couple passé en paramètre retourne bien le seul mot suivant possible
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        String path = "textRead2.txt";
        Couple p = new Couple("esirem", "ecole");
        Markov instance = new Markov();
        instance.readFile(path);
        List<String> result = instance.couples.get(p);
        String expResult = "facile";
        assertEquals(expResult, result.get(0));
    }

    /**
     * Test of generateText method, of class Markov.
     * 
     */
    @Test
    public void testGenerateText() {
        System.out.println("generateText");
        Couple p = new Couple("ecole", "esirem");
        int words = 2;
        Markov instance = new Markov();
        String expResult = "ecole esirem ";
        String result = instance.generateText(p, words);
        assertEquals(expResult, result);
    }

    @Test
    public void testHashCode(){
        Couple p = new Couple("ecole", "ecole");
        int result = p.hashCode();
        int expResult = "ecole".hashCode()*2;
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testHashCodeEclipse(){
        Couple p = new Couple("esirem", "ecole");
        final int prime = 31;
	int result = 1;
	result = prime * result + ((p.getFirst() == null) ? 0 : p.getFirst().hashCode());
	result = prime * result + ((p.getSecond() == null) ? 0 : p.getSecond().hashCode());
        int expResult = 1;
        expResult = prime * expResult + "esirem".hashCode();
        expResult = prime * expResult + "ecole".hashCode();
        assertEquals(expResult, result);
    }
}
