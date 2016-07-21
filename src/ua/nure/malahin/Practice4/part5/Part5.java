package ua.nure.malahin.Practice4.part5;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 01.06.16.
 */
public class Part5 {

    public Part5(){}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp1251");
        Pattern p = Pattern.compile("^(\\w+)( )(\\w+)$");
        Matcher m;
        while (in.hasNextLine()) {
            m = p.matcher(in.nextLine());
            if (m.find()) {
                System.out.println(getData(m.group(1), m.group(3)));
            }
        }
    }

    public static String getData(String key, String param){        
        ResourceBundle rb = ResourceBundle.getBundle("resources", new Locale(param));
        return rb.getString(key);
    }

}
