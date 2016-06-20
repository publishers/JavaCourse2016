package ua.nure.malahin.Project3.part5;

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
                tmp.append(baseDigit(base)).append(baseDigit(base * 10));
                x = x - 9 * base;
            } else if (x >= 5 * base) {
                tmp.append(baseDigit(5 * base));
                x = x - 5 * base;
            } else if (x >= 4 * base) {
                tmp.append(baseDigit(base)).append(baseDigit(base * 5));
                x = x - 4 * base;
            }
            while (x >= base) {
                tmp.append(baseDigit(base));
                x = x - base;
            }
        }

        return tmp.toString();
    }

    public static int roman2Decimal(String s) {
        int sum = 0;
        int lastRome = 0;
        for (char c : s.toCharArray()) {
            int r = basedString(c);
            if (sum >= r) {
                if (lastRome < r) {
                    sum += r - 2 * lastRome;
                    lastRome = r;
                } else {
                    sum += r;
                    lastRome = r;
                }
            } else {
                sum = r - sum;
                lastRome = r;
            }
        }
        return sum;
    }

    public static String baseDigit(int x) {
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

    public static int basedString(char x) {
        switch (x) {
            case 'I':
                return 1;

            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;

            default:
                return 0;
        }
    }


    public static void main(String[] args) throws Exception {

        for (int i = 1; i < 101; i++) {
            String deciman2Roman = decimal2Roman(i);
            System.out.print(i + " ===> ");
            System.out.print(deciman2Roman + " ===> ");
            System.out.println(roman2Decimal(deciman2Roman));
        }

    }

}
