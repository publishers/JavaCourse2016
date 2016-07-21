package ua.nure.malahin.Practice4.part3;

import ua.nure.malahin.Practice4.Util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 01.06.16.
 */
public class Part3 {
    public static final String SEPARATOR = "\\S+";
    public static final String REG_CHAR = "^\\S$";
    public static final String REG_WORD = "^\\S+$";
    public static final String REG_INT = "^(-|)\\d+$";
    public static final String REG_DOUBLE = "^(((-|)\\d+\\.(\\d+|))|((-|)\\.\\d+))$";


    public static void main(String[] args) {
        String inputLine = Util.getInput("part3.txt");
        Scanner in = new Scanner(System.in, "cp1251");
        while (in.hasNextLine()) {
            System.out.println(getObject(in.nextLine(), inputLine));
        }
    }

    public static String getObject(String getSMTH, String input){
        String getOBJ;
        if(getSMTH.equals("char")){
            getOBJ = REG_CHAR;
        }else
        if(getSMTH.equals("String")){
            getOBJ = REG_WORD;
        }else
        if(getSMTH.equals("int")){
            getOBJ = REG_INT;
        }else
        if(getSMTH.equals("double")){
            getOBJ = REG_DOUBLE;
        }else {
            throw new IllegalStateException();
        }

        Pattern pat = Pattern.compile(SEPARATOR);
        Matcher m = pat.matcher(input);
        StringBuilder sb = new StringBuilder();

        while(m.find()){
            Matcher mDouble = Pattern.compile(getOBJ).matcher(m.group());
            if (mDouble.find()){
                sb.append(mDouble.group()).append(" ");
            }
        }
        return sb.toString();
    }


}
