package ua.nure.malahin.Practice5.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by sergey on 06.06.16.
 */
public class Part6 {

    private Thread[] threads;
    private RandomAccessFile raf = null;
    private static final String FILENAME = "part6.txt";

    public Part6() throws FileNotFoundException {
	threads = new WriterToFile[10];
	raf = new RandomAccessFile(FILENAME, "rw");
	for (int i = 0; i < threads.length; i++) {
	    threads[i] = new WriterToFile(raf, i * 20 + i);
	}
    }

    private void waitAllThreads() throws InterruptedException {
	for (int i = 0; i < threads.length; i++) {
	    while (threads[i].isAlive()) {
		Thread.sleep(10);
	    }	    
	}
    }

    public void run() throws InterruptedException, IOException {

	for (int i = 0; i < threads.length; i++) {
	    threads[i].start();
	}

	waitAllThreads();

	System.out.println(read());
    }

    public static void deleteFile() throws FileNotFoundException {
	File file = new File(FILENAME);
	if (file.exists() && !file.delete()) {
	    System.out.println("File wasn't deleted");
	}
    }

    public String read() throws IOException {
	raf = new RandomAccessFile(FILENAME, "r");
	StringBuilder sb = new StringBuilder();
	int b = raf.read();

	while (b != -1) {
	    sb.append((char) b);
	    b = raf.read();
	}
	raf.close();

	return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
	Part6.deleteFile();
	Part6 p6 = new Part6();
	p6.run();

    }

}