package ua.nure.malahin.Practice5.part4;

/**
 * Created by sergey on 07.06.16.
 */
public class ParallelSearcher extends Thread{
    private int maxVal;
    private int [] arr;

    public ParallelSearcher(int[] getArr){
        this.arr = getArr.clone();
    }

    public void run(){
        findMaxValue();
    }

    private void findMaxValue(){
        maxVal = arr[0];
        for (int i : this.arr){
            if (i > maxVal){
                maxVal = i;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
        	System.out.println(e);
            }
        }
    }

    public int getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(int maxval) {
        this.maxVal = maxval;
    }


}
