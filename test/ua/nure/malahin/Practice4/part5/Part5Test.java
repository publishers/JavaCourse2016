package ua.nure.malahin.Practice4.part5;

import org.junit.Test;
import ua.nure.malahin.Practice4.part5.Part5;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by sergey on 01.06.16.
 */
public class Part5Test {
    @Test
    public void testMain(){
        try {
            System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes("cp1251")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Part5.main(new String[]{});
    }

    @Test
    public void testConstructor(){
        new Part5();
    }
}
