package ua.nure.malahin.Practice1;

/**
 * Created by sergey on 29.04.16.
 */
public class Sum {

    public static int add(int x, int y){
        return x + y;
    }

    public static void main(String[] args){
        if(args.length == 2) {
            int d1 = Integer.parseInt(args[0]);
            int d2 = Integer.parseInt(args[1]);

            System.out.println(args[0] + " + " + args[1] + " = " + add(d1, d2));
        }
    }
}
