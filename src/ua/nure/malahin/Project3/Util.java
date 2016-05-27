package ua.nure.malahin.Project3;

/**
 * Created by sergey on 25.05.16.
 */

import java.io.*;
import java.util.Scanner;

public class Util {
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = Util.getInput("/home/sergey/Documents/JavaLab/Project3/src/part1.txt");
        System.out.println(input);
    }
}
