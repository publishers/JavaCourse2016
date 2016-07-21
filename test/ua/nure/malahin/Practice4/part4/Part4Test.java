package ua.nure.malahin.Practice4.part4;

import org.junit.Test;

import junit.framework.Assert;
import ua.nure.malahin.Practice4.Util;
import ua.nure.malahin.Practice4.part4.Part4;

import java.util.Iterator;


/**
 * Created by sergey on 01.06.16.
 */
@SuppressWarnings("deprecation")
public class Part4Test {
    
    private String[] output = {"When I was younger, so much younger than.",
	    "I never needed anybody's help in any way.",
    	 "But now these days are gone, I'm not so self-assured.",
    	 "Now I find I've changed my mind.",
    	 "I've opened up the doors."};
    
    @Test
    public void testMain(){
        Part4.main(new String[]{});        
    }

    @Test
    public void testConstructor(){
        new Part4("hello");
    }
    
    @Test
    public void testIterator(){
	String sentences = Util.getInput("part4.txt");
        Part4 p4 = new Part4(sentences);
        Iterator<String> iter = p4.iterator();
        while(iter.hasNext()){           
            Assert.assertEquals(iter.next().intern(), iter.next().intern());
        }
	
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testRemove(){
        String sentences = Util.getInput("part4.txt");
        Part4 p4 = new Part4(sentences);
        Iterator<String> iter = p4.iterator();
	iter.remove();
    }
}
