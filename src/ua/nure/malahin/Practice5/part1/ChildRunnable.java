package ua.nure.malahin.Practice5.part1;

/**
 * Created by sergey on 07.06.16.
 */
public class ChildRunnable implements Runnable {

    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();
        while(5000 >= System.currentTimeMillis()-timeStart){
            try{
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }
}