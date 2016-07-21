package ua.nure.malahin.Practice5.part2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by sergey on 06.06.16.
 */
public class Part2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        InputStream stdIn = System.in;

        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes("cp1251"));
        
        bais.skip(System.lineSeparator().length());

        System.setIn(bais);

        Spam.main(args);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Try to send enter to standard input");

        bais.reset();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.setIn(stdIn);

    }
}
