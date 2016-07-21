package ua.nure.malahin.Practice6;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import ua.nure.malahin.Practice6.part1.WordContainer;
import ua.nure.malahin.Practice6.part2.CirclePeople;
import ua.nure.malahin.Practice6.part3.ParkingPlace;
import ua.nure.malahin.Practice6.part4.Graf;
import ua.nure.malahin.Practice6.part5.Tree;
import ua.nure.malahin.Practice6.part6.Part6;
import ua.nure.malahin.Practice6.part7.Range;

/**
 * Created by sergey on 15.06.16.
 */
public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("asd\nasdf\nasd\nasdf\nasdf\n43\nasdsf\n43\n43\n434".getBytes("cp1251")));
        
        WordContainer.main(args);
        printSeparator();

        CirclePeople.main(args);
        printSeparator();
        
        ParkingPlace.main(args);
        printSeparator();
       
        Graf.main(args);
        printSeparator();
        
        Tree.main(args);
        printSeparator();
        
        Part6.main(args);
        printSeparator();
        
        Range.main(args);
        printSeparator();

    }
    
    private static void printSeparator(){
	System.out.println("================================");
    }
}
