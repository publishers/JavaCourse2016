package expir;

import ua.nure.malahin.Project3.Util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 25.05.16.
 */
public class Regexp {
//    public static final String REGEXP= "(?m)^(.+);(.+);(.+)@(.+)$";
//
//    public static void setRegexp(String input){
//        Pattern pattern = Pattern.compile(REGEXP);
//        Matcher m = pattern.matcher(input);
//        StringBuilder sb = new StringBuilder();
//
//        ArrayList<String> doms = new ArrayList<String>(2);
//        while(m.find()){
//            if(!doms.contains(m.group(4))){
//                doms.add(m.group(4));
//            }
//        }
//
//        for (String s : doms){
//            m.reset();
//            sb.append(s).append(" ===> ");
//                while(m.find()){
//                    if(s.equals(m.group(4))){
//                        sb.append(m.group(3)).append(", ");
//                    }
//                }
//            sb.delete(sb.length()-2, sb.length()).append("\n");
//        }
//        System.out.println(sb);
//    }

    public static final String REGEXP= "([A-z]+)";

    public static void findWords (String input){
        Pattern p = Pattern.compile(REGEXP);
        Matcher m = p.matcher(input);
        int min = Integer.MAX_VALUE, max = 0;
        while (m.find()){
            if(min > m.group().length()){
                min = m.group().length();
            }
            if(max < m.group().length()){
                max = m.group().length();
            }
        }
        m.reset();
//        StringBuilder sbMin = new StringBuilder();
//        StringBuilder sbMax = new StringBuilder();
//        S
//        while (m.find()){
//            if(min == m.group().length()){
//                sbMin.append(m.group()).append(", ");
//            }
//            if(max == m.group().length()){
//                sbMax.append(m.group()).append(", ");
//            }
//        }
//        sbMax.delete(sbMax.length()-2,sbMax.length());
//        sbMin.delete(sbMin.length()-2,sbMin.length());
//        sbMin.append("\n");
//        sbMin.append(sbMax);
//        System.out.println(sbMin);
    }

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        findWords(input);
    }
}
