package ua.nure.malahin.Practice4.part3;

import org.junit.Test;
import ua.nure.malahin.Practice4.part3.Part3;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by sergey on 01.06.16.
 */
public class Part3Test {

    private static final String ENCODING = "Cp1251";

    @Test(expected = IllegalStateException.class)
    public void testMainException(){
        try {
            System.setIn(new ByteArrayInputStream("Double".getBytes(ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Part3.main(new String[]{});
    }

    @Test
    public void testMainChar() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("char".getBytes(ENCODING)));
        Part3.main(new String[]{});
    }

    @Test
    public void testMainDouble() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("double".getBytes(ENCODING)));
        Part3.main(new String[]{});
    }

    @Test
    public void testMainString() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("String".getBytes(ENCODING)));
        Part3.main(new String[]{});
    }

    @Test
    public void testMainInt() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("int".getBytes(ENCODING)));
        Part3.main(new String[]{});
    }

    @Test
    public void testConstructor(){
        new Part3();
    }
}
