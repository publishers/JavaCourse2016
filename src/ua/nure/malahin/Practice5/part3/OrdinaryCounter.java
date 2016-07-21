package ua.nure.malahin.Practice5.part3;

/**
 * Created by sergey on 07.06.16.
 */
public class OrdinaryCounter implements Counter{
    private int countOne;
    private int countTwo;

    @Override
    public void increment() {
        try {
            Thread.sleep(10);

            countTwo++;

            Thread.sleep(10);

            countOne++;
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    @Override
    public void equal() {
        System.out.println(" count1 = " + countOne + " count2="+ countTwo + " |" +(
                countOne > countTwo
                        ? "c1 more then c2"
                        :
                        countOne == countTwo ? "c1==c2" : "c2 more then c1"));
    }

    public int getCountOne() {
        return countOne;
    }

    public void setCountOne(int countOne) {
        this.countOne = countOne;
    }

    public int getCountTwo() {
        return countTwo;
    }

    public void setCountTwo(int countTwo) {
        this.countTwo = countTwo;
    }
}