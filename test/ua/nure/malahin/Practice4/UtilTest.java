package ua.nure.malahin.Practice4;


import org.junit.Test;


import java.io.IOException;

/**
 * Created by sergey on 02.06.16.
 */
public class UtilTest {

    @Test
    public void testUtil(){
        new Util();
    }
    
    @Test(expected = IOException.class)
    public void testException() throws IOException{
	Util.callIOException(null);
    }
    
    @Test
    public void testcallIOException()throws IOException{
	Util.callIOException("part3.txt");
    }

}
