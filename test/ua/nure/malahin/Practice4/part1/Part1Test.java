package ua.nure.malahin.Practice4.part1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import ua.nure.malahin.Practice4.part2.Part2Test;

/**
 * Created by sergey on 01.06.16.
 */

public class Part1Test{
    

    private String input = "Hello world is a word!";
    private String out = "HELLO WORLD is a WORD!";

    @Test
    public void testConvertToUpperMoreFour(){
        Assert.assertEquals(out, Part1.convertToUpperMoreFour(input));
    }

    @Test
    public void testMain(){
        Part1.main(new String[]{});
    }

    @Test
    public void testConstructor(){
      new Part1();
    }

   

}
