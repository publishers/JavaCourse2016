package ua.nure.malahin.Practice1;

/**
 * Created by sergey on 29.04.16.
 */
public class Nod {

    public static int getNod(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
//Evklid google
    public static void main(String[] args) {

            int i1 = Integer.parseInt(args[0]);
            int i2 = Integer.parseInt(args[1]);
            System.out.println(getNod(i1, i2));

    }
}
