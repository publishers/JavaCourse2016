package ua.nure.malahin.Practice4.part2;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by sergey on 01.06.16.
 */
public class Part2 {


    public static void main(String[] args) throws IOException {
        createRandomFile();
        int[] arr = readFromIntFile();
        System.out.println(Arrays.toString(arr));
        boobleSort(arr);
        writeToFile(arr);
    }

    public static int[] readFromIntFile()throws IOException{
        File f = new File("RandomFile.txt");
        int[] arr = new int[10];

        Scanner scan = new Scanner(f, "cp1251" );
        int i = 0;
        while(scan.hasNext()){
            arr[i++] = scan.nextInt();
        }
        return arr;
    }

    public static void createRandomFile() throws IOException {
        PrintWriter pw = new PrintWriter(new File("RandomFile.txt"), "cp1251");
        Random randomInt = new Random();
        for (int i = 0; i < 10; i++) {
            pw.print((int)(randomInt.nextInt() * 50));
            pw.append(" ");
            pw.flush();
        }
        pw.close();
    }

    public static void writeToFile(int[] arr) throws IOException {
        PrintWriter pw = new PrintWriter(new File("RandomOutFile.txt"), "cp1251");
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            pw.print(i);
            pw.append(" ");
            pw.flush();
        }
        pw.close();
    }

    public static int[] boobleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i]> arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }



}
