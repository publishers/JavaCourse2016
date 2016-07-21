package ua.nure.malahin.Practice4.part1;

import ua.nure.malahin.Practice4.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 01.06.16.
 */
public class Part1 {

    private static final String REGEX = "((\\S+('|-))|(\\S+\\s)|(\\S+$))";

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.println(convertToUpperMoreFour(input));
    }

    public static String convertToUpperMoreFour(String input){
        Pattern pat = Pattern.compile(REGEX);
        Matcher mat = pat.matcher(input);
        StringBuilder sb = new StringBuilder();
        while(mat.find()){
            sb.append(mat.group().length() > 4 ? mat.group().toUpperCase() : mat.group());
        }
        return sb.toString();
    }


}
