package ua.nure.malahin.Practice5.part2;

/**
 * Created by sergey on 07.06.16.
 */
public class Worker extends Thread{
    private int time;
    private String  name;

    Worker(int time, String name){
        this.time = time;
        this.name = name;
    }

    @Override
    public void run(){
        while(!isInterrupted()) {
            System.out.println(name);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
        	System.out.println(e);
            }
        }
    }
}