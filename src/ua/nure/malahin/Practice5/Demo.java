package ua.nure.malahin.Practice5;

import ua.nure.malahin.Practice5.part1.Part1;
import ua.nure.malahin.Practice5.part2.Part2;
import ua.nure.malahin.Practice5.part3.Part3;
import ua.nure.malahin.Practice5.part4.Part4;
import ua.nure.malahin.Practice5.part5.Part5;
import ua.nure.malahin.Practice5.part6.Part6;

import java.io.IOException;

/**
 * Created by sergey on 26.06.16.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException, IOException {

        printSeparator(0);
        System.out.println("PART1");
        Part1.main(args);

        printSeparator(6000);
        System.out.println("PART2");
        Part2.main(args);

        printSeparator(6000);
        System.out.println("PART3");
        Part3.main(args);

        printSeparator(6000);
        System.out.println("PART4");
        Part4.main(args);

        printSeparator(6000);
        System.out.println("PART5");
        Part5.main(args);


        printSeparator(6000);
        System.out.println("PART6");

        Part6.main(args);

    }

    public static void printSeparator(int timeSleep) throws InterruptedException {
        Thread.sleep(timeSleep);
        System.out.print("===========================");

    }
}
