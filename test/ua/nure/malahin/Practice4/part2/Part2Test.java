package ua.nure.malahin.Practice4.part2;

import org.junit.Assert;
import org.junit.Test;
import ua.nure.malahin.Practice4.part2.Part2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by sergey on 01.06.16.
 */
public class Part2Test {

    @Test
    public void testMain(){
        try {
            Part2.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConstructor(){
        new Part2();
    }

    @Test
    public void testSort(){
        int [] output = new int[]{3, 9, 16, 16, 18, 21, 23, 23, 29, 30};
        int [] input = new int[]{30, 23, 16, 16, 9, 23, 3, 18, 21, 29};
        Assert.assertArrayEquals(output, Part2.boobleSort(input));
    }

}
