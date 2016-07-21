package ua.nure.malahin.Practice5.part3;

/**
 * Created by sergey on 07.06.16.
 */
public class SynchronizedCounter implements Counter{
    private int countOne;
    private int countTwo;


    public int getCountOne() {
        return countOne;
    }


    public int getCountTwo() {
        return countTwo;
    }

    @Override
    public synchronized void increment() {
        try {
            Thread.sleep(10);

            countTwo++;

            Thread.sleep(10);

            countOne++;
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    
    public synchronized void equal() {
        System.out.println(" count1 = " + countOne + " count2="+ countTwo + " |" +(
                countOne > countTwo
                        ? "c1 more then c2"
                        :
                        countOne == countTwo ? "c1==c2" : "c2 more then c1"));
    }
}