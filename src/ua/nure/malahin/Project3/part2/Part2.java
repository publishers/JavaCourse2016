package ua.nure.malahin.Project3.part2;

import ua.nure.malahin.Project3.Util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 25.05.16.
 */
public class Part2 {
    private static  int minVal = Integer.MAX_VALUE;
    private static  int maxVal = 0;

    public static final String REGEXP= "([A-z]+)";

    public static void foundMinMaxValue(String input){

        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(input);

        while(m.find()){
            if(m.group().length() < minVal){
                minVal = m.group().length();
            }

            if(m.group().length() > maxVal){
                maxVal = m.group().length();
            }
        }
    }

    public static String getMinMax(String input){
        foundMinMaxValue(input);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(input);
        Set min = new LinkedHashSet();
        Set max = new LinkedHashSet();

        while(m.find()){
            if(m.group().length() == minVal){
                min.add(m.group());
            }

            if(m.group().length() == maxVal){
                max.add(m.group());
            }
        }
        sb.append("Min: ");
        concat(min.iterator(), sb);
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n");

        sb.append("Max: ");
        concat(max.iterator(), sb);
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private static void concat(Iterator i, StringBuilder sb){
        while (i.hasNext()){
            sb.append(i.next() + ", ");
        }
    }

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.println(getMinMax(input));
    }
}
