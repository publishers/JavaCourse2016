package ua.nure.malahin.Practice5.part6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by sergey on 07.06.16.
 */
public class WriterToFile extends Thread{
    private RandomAccessFile file;
    private int line;

    WriterToFile(RandomAccessFile file, int line){
        this.line = line;
        this.file = file;
        
    }

    public void writeToFile() throws IOException {
        synchronized (file) {
            try {
        	        	
                file.seek(line);
                for (int i = 0; i < 20; i++) {

                    file.write((line / 20 + "").getBytes("cp1251"));

                }
                file.write(System.lineSeparator().getBytes("cp1251"));


            } catch (FileNotFoundException e) {
        	System.out.println(e);
            }
        }
    }

    public void run(){
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}