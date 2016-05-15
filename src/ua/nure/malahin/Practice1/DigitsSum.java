package ua.nure.malahin.Practice1;

/**
 * Created by sergey on 29.04.16.
 */
public class DigitsSum {

    public static int digSum(int dig) {
        int sum = 0;
        while (dig > 0) {
            sum += dig % 10;
            dig /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        args = new String[]{"123", "3456"};
        for (String s : args){
            int digSum = digSum(Integer.parseInt(s));
            System.out.println("Sum of " + s + " is " + digSum);
        }
    }

}
