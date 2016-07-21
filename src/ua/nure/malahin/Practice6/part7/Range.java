package ua.nure.malahin.Practice6.part7;

import java.util.Iterator;

/**
 * Created by sergey on 15.06.16.
 */
public class Range {
    private int n, m;
    private boolean mark;
    public Range(int n , int m){
        this.n = n;
        this.m = m;
        this.mark = true;
    }


    public void reverse(boolean b){
        mark = b;
    }

    public Iterable<Integer> iterable() {
        return new Step();
    }

    private class Step implements Iterable<Integer>{
        private int step;
        public Step(){
            if (mark){
        	step = n - 1;
            }
            else{
        	step = m + 1;
            }
        }     
        
	@Override
	public Iterator<Integer> iterator() {
	    return new InnerIterator();
	}
        
	private class InnerIterator implements Iterator<Integer>{
	    @Override
	        public boolean hasNext() {
	            if(mark){
	                step++;
	            }else{
	                step--;
	            }
	            return !(step > m || step < n);
	        }

	        @Override
	        public Integer next() {
	            return step;
	        }
	        
	        @Override
	        public void remove(){
	            throw new IllegalStateException();
	        }
	}
        
    }


    public static void main(String[] args) {
        Range r = new Range(1, 8);
        Iterator<Integer> it = r.iterable().iterator();
        r.reverse(true);
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        r.reverse(false);
        it = r.iterable().iterator();
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }
        System.out.println();
        r.reverse(true);
        it = r.iterable().iterator();
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }

    }
}
