package ua.nure.malahin.Practice5.part1;

/**
 * Created by sergey on 06.06.16.
 */
public class Part1 {
    public static void main(String[] args) {
        new ChildThread().start();
        new Thread(new ChildRunnable()).start();
    }
}


