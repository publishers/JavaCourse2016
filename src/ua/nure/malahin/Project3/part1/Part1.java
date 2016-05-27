package ua.nure.malahin.Project3.part1;

import ua.nure.malahin.Project3.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 25.05.16.
 */
public class Part1 {

    public static final String REGEXP= "(?m)^(.+);(.+);(.+)@(.+)$";

    public static String convert1(String inputLine){
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(inputLine);

        if (m.find()){
            m.group();
        }
        while(m.find()){
            sb.append(m.group(1)).append(" ====> ").append(m.group(3)).append("@").append(m.group(4)).append("\n");
        }

        return sb.toString();
    }

    public static String convert2(String inputLine){
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(inputLine);

        if (m.find()){
            m.group();
        }
        while(m.find()){
            sb.append(m.group(2)).append(" (email: ").append(m.group(3)).append("@").append(m.group(4)).append(")\n");
        }

        return sb.toString();
    }

    public static String convert3(String inputLine){
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher m = pattern.matcher(inputLine);
        StringBuilder sb = new StringBuilder();

        ArrayList<String> doms = new ArrayList<String>(2);
        while(m.find()){
            if(!doms.contains(m.group(4))){
                doms.add(m.group(4));
            }
        }

        for (String s : doms){
            m.reset();
            sb.append(s).append(" ===> ");
            while(m.find()){
                if(s.equals(m.group(4))){
                    sb.append(m.group(3)).append(", ");
                }
            }
            sb.delete(sb.length()-2, sb.length()).append("\n");
        }
        return sb.toString();
    }

    public static String convert4(String inputLine){
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(.+);(.+);(.+)$");
        Matcher m = pattern.matcher(inputLine);

        if (m.find()){
            sb.append(m.group()).append(";Password").append("\n");
        }
        while(m.find()){
            sb.append(m.group()).append(";" + Math.round(Math.random() * 1000000)).append("\n");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");

        System.out.println(convert1(input));
        System.out.println();
        System.out.println(convert2(input));
        System.out.println();
        System.out.println(convert3(input));
        System.out.println();
        System.out.println(convert4(input));
    }
}