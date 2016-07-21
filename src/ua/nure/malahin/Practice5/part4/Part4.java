package ua.nure.malahin.Practice5.part4;

import java.util.Random;

/**
 * Created by sergey on 06.06.16.
 */
public class Part4 {

    private static int[][] matrix;
    private ParallelSearcher[] searchers;
    private OrdinalSearcher ordinalSearcher;

    public static void main(String[] args) {
        int[][] matrixTmp  = new int [5][100];
        Random r = new Random(100000);
        for (int i = 0; i < matrixTmp.length; i++) {
            for (int j = 0; j < matrixTmp[0].length; j++) {
                matrixTmp[i][j] = r.nextInt();
            }
        }
        for (int i = 0; i < matrixTmp.length; i++) {
            for (int j = 0; j < matrixTmp[0].length; j++) {
                System.out.print(matrixTmp[i][j] + " ");
            }
            System.out.println();
        }
        
        Part4.setMatrix(matrixTmp);
        Part4 part4 = new Part4();
        
        long timeParallelStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithParallelSearch());
        System.out.println("time for parallel is " + (System.currentTimeMillis() - timeParallelStart));


        long timeOrdinalStart = System.currentTimeMillis();
        System.out.println(part4.findMaxValWithOrdinalSearch());
        System.out.println("time for ordinal is " + (System.currentTimeMillis() - timeOrdinalStart));


    }

    public Part4(){	
        searchers = new ParallelSearcher[Part4.matrix.length];
        ordinalSearcher = new OrdinalSearcher(Part4.matrix);        
    }
    
    public static void setMatrix(int[][]matrix){
	Part4.matrix = matrix.clone();
    }

    public int findMaxValWithParallelSearch(){
        for (int i = 0; i < matrix.length; i++) {
            searchers[i] = new ParallelSearcher(matrix[i]);
            searchers[i].start();
        }

        try {
	    waitAllThreads();
	} catch (InterruptedException e) {
	    System.out.println(e);
	}

        int maxVal = searchers[0].getMaxVal();
        for (int i = 0; i < searchers.length; i++) {
            if (maxVal < searchers[i].getMaxVal()){
                maxVal = searchers[i].getMaxVal();
            }
        }
        return maxVal;
    }

    public void waitAllThreads() throws InterruptedException{
        for (int i = 0; i < searchers.length; i++) {
            while(searchers[i].isAlive()){
        	Thread.sleep(10);
            }
        }
    }

    public int findMaxValWithOrdinalSearch(){
       return ordinalSearcher.getMaxVal();
    }
}
