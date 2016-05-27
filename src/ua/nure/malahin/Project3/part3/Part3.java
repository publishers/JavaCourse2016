package ua.nure.malahin.Project3.part3;

import ua.nure.malahin.Project3.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 25.05.16.
 */
public class Part3 {


    public static final String REGEXP= "([A-z]{1})(\\S+\\s|\\s|\\S+$)";

    public static String eachFirstLetterToUpperCase(String input){
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while(m.find()){
            sb.append(m.group(1).toUpperCase() + m.group(2));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.println(eachFirstLetterToUpperCase(input));
    }
}
