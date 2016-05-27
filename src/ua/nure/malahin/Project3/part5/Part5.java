package ua.nure.malahin.Project3.part5;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sergey on 26.05.16.
 */
public class Part5 {

    public static String decimal2Roman(int x) {

        StringBuilder tmp = new StringBuilder();
        while (x > 0) {
            int base = 0;
            if ((x >= 1) && (x <= 9))
                base = 1;
            else if ((x >= 10) && (x <= 99))
                base = 10;
            else if ((x >= 100) && (x <= 999))
                base = 100;
            else if ((x >= 1000) && (x <= 3999))
                base = 1000;
            else if (x >= 4000) {
                return "error";
            }



           if (x >= 9 * base) {
                tmp.append(basedigit(base)).append(basedigit(base * 10));
                x = x - 9 * base;
            } else if (x >= 5 * base) {
                tmp.append(basedigit(5 * base));
                x = x - 5 * base;
            } else if (x >= 4 * base) {
                tmp.append(basedigit(base)).append(basedigit(base * 5));
                x = x - 4 * base;
            }
            while (x >= base) {
                tmp.append(basedigit(base));
                x = x - base;
            }
        }

        return tmp.toString();
    }

    public static String basedigit(int x) {  //Convert base digit 1,5,10,50,100,500,1000 to Rom digit

        switch (x) {
            case 1:
                return "I";

            case 5:
                return "V";

            case 10:
                return "X";

            case 50:
                return "L";

            case 100:
                return "C";

            case 500:
                return "D";

            case 1000:
                return "M";

            default:
                return "I dont know";
        }
    }

    public static int roman2Decimal(String s) {
        int sum = 0;
        ROME lastRome = ROME.I;
        for (char c : s.toCharArray()) {
            for (ROME r : ROME.values()) {
                if (c == r.getC()) {
                    if (sum >= r.getI()) {
                        if (lastRome.getI() < r.getI()) {
                            sum += r.getI() - 2 * lastRome.getI();
                            lastRome = r;
                            break;
                        }
                        sum += r.getI();
                        lastRome = r;
                        break;
                    } else {
                        sum = r.getI() - sum;
                        lastRome = r;
                        break;
                    }
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(decimal2Roman(99));
    }

}

enum ROME {
    I(1, 'I'), V(5, 'V'), X(10, 'X'), L(50, 'L'), C(100, 'C'), D(500, 'D'), M(1000, 'M');
    int i;
    char c;

    ROME(int i, char c) {
        this.i = i;
        this.c = c;
    }

    public int getI() {
        return i;
    }

    public char getC() {
        return c;
    }
}