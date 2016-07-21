package ua.nure.malahin.Practice5.part3;

/**
 * Created by sergey on 06.06.16.
 */
public class Part3 extends Thread{
    private static  final OrdinaryCounter OC = new OrdinaryCounter();
    private static  final SynchronizedCounter SC = new SynchronizedCounter ();

    public void run(){
        int i = 0;
        long time = System.currentTimeMillis();
        while(i <  10){
            OC.equal();
            OC.increment();
            i++;
        }
        System.out.println("Ordinal is "+ (System.currentTimeMillis()-time));

        i=0;
        time = System.currentTimeMillis();
        while(i <  10){
            SC.equal();
            SC.increment();
            i++;
        }

        System.out.println("Synchronized is " + (System.currentTimeMillis()-time));
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[]{new Part3(),new Part3(),new Part3()};
        for (Thread thr : threads){
            thr.start();
        }
    }
}
