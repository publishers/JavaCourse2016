package ua.nure.malahin.Practice5.part4;

/**
 * Created by sergey on 07.06.16.
 */
public class OrdinalSearcher {

    private int [][] arr;

    public OrdinalSearcher(int[][] getArr){
        this.arr = getArr.clone();
    }

    public int getMaxVal(){
	int maxVal = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > maxVal){
                    maxVal = arr[i][j];
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }

        return maxVal;
    }

}
