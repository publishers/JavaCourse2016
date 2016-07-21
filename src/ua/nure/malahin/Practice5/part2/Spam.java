package ua.nure.malahin.Practice5.part2;

import java.io.IOException;

/**
 * Created by sergey on 06.06.16.
 */
public class Spam {

    private Thread[] threads;

    public void start() {
	for (Thread t : threads) {
	    t.start();
	}
    }

    public void stop() {
	for (Thread t : threads) {
	    t.stop();
	}
    }

    public Spam(int[] times, String[] names) {
	threads = new Worker[times.length];
	for (int i = 0; i < times.length; i++) {
	    threads[i] = new Worker(times[i], names[i]);
	}
    }

    public static void main(String[] args) {
	final Spam spam = new Spam(new int[] { 1000, 3330, 2000 }, new String[] { "mess1", "mess2", "mess3" });
	spam.start();
	spam.pressEnter();

    }

    public void pressEnter() {
	new Thread() {
	    public void run() {
		Spam.this.run();
	    }
	}.start();
    }

    private synchronized void run() {
	byte[] buff = new byte[10];
	int count = 0;
	try {
	    String enter;
	    do {
		while ((count = System.in.read(buff)) == -1) {
		    Thread.sleep(10);
		}
		enter = new String(buff, 0, count, "cp1251");
	    } while (!System.lineSeparator().equals(enter));
	    Spam.this.stop();
	} catch (IOException e) {
	    System.out.println(e);
	} catch (InterruptedException e) {
	    System.out.println(e);
	}
    }
}