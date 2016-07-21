package ua.nure.malahin.Practice4;

import java.io.IOException;

import org.junit.Test;

public class DemoTest {

    @Test
    public void testConstr(){
	new Demo();
    }
    @Test
    public void testDemoMain(){
	try {
	    Demo.main(new String[]{});	    
	} catch (IOException e) {
	    System.err.println(e);
	}
    }
}
