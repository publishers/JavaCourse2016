package ua.nure.malahin.Practice4;

import ua.nure.malahin.Practice4.part1.Part1;
import ua.nure.malahin.Practice4.part2.Part2;
import ua.nure.malahin.Practice4.part3.Part3;
import ua.nure.malahin.Practice4.part4.Part4;
import ua.nure.malahin.Practice4.part5.Part5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sergey on 01.06.16.
 */
public class Demo {
    private static final InputStream STD_IN = System.in;
    private static final String ENCODING = "Cp1251";
    public static void main(String[] args) throws IOException {
//	printSeparator();
//	System.out.println("PART1");
//        Part1.main(args);
//
//        printSeparator();
//        System.out.println("PART2");
//        Part2.main(args);
//
//        printSeparator();
//        System.out.println("PART3");
//
//        System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble".getBytes(ENCODING)));
//        Part3.main(args);
//
//        System.setIn(STD_IN);
//
//        printSeparator();
//        System.out.println("PART4");
//        Part4.main(args);

        printSeparator();
        System.out.println("PART5");

        System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes(ENCODING)));
        Part5.main(args);

    }
    
    public static void printSeparator(){
	System.out.print("===========================");
    }
}