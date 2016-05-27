package ua.nure.malahin.Project3.part5;

/**
 * Created by sergey on 27.05.16.
 */
public class Roman {
        /*
    *
1 ====> I ====> 1
2 ====> II ====> 2
3 ====> III ====> 3
4 ====> IV ====> 4
5 ====> V ====> 5
...
94 ====> XCIV ====> 94
95 ====> XCV ====> 95
96 ====> XCVI ====> 96
97 ====> XCVII ====> 97
98 ====> XCVIII ====> 98
99 ====> XCIX ====> 99
100 ====> C ====> 100
    * */

    public static void convert(int x){
        StringBuilder s = new StringBuilder();
        while (x > 0) {
            if (x >= 1 && x < 4) {
                s.append(basedigit(1));
                x = x - 1;
            }else if (x == 4){
                s.append(basedigit(1)).append(basedigit(5));
                x = x - 4;
            }else if (x>=5 && x < 9){
                s.append(basedigit(5));
                x = x - 5;
            }else if (x == 9){
                s.append(basedigit(1)).append(basedigit(10));
                x = x - 9;
            }else if (x >= 10 && x <40){
                s.append(basedigit(10));
                x = x - 10;
            }else if (x >= 40 && x < 50){
                s.append(basedigit(10)).append(basedigit(50));
                x = x - 40;
            }else if (x >= 50 && x < 90){
                s.append(basedigit(50));
                x = x - 50;
            }else if (x >= 90 && x < 100){
                s.append(basedigit(10)).append(basedigit(100));
                x = x - 90;
            }else if (x >= 100 && x < 400){
                s.append(basedigit(100));
                x = x - 100;
            }else if (x >= 400 && x < 500){
                s.append(basedigit(100)).append(basedigit(500));
                x = x - 400;
            }else if (x >= 500 && x < 900){
                s.append(basedigit(500));
                x = x - 500;
            }else if (x >= 900 && x < 1000){
                s.append(basedigit(100)).append(basedigit(1000));
                x = x - 900;
            } else if (x > 1000 && x < 4000){
                s.append(basedigit(1000));
                x = x - 1000;
            } else {
                System.out.println("error");
                break;
            }
        }
        System.out.println(s);
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

    public static void main(String[] args) {
        convert(99);
    }

}
