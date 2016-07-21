package ua.nure.malahin.Practice5.part6;

/**
 * Created by sergey on 07.06.16.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class WorkWithFile {

    private String path;

    private RandomAccessFile file;

    public WorkWithFile(String path) {
        this.path = path;
    }

    public long goTo(int num) throws IOException {

        file = new RandomAccessFile(path, "r");

        file.seek(num);

        long pointer = file.getFilePointer();
        file.close();

        return pointer;
    }


    public String read() throws IOException {
        file = new RandomAccessFile(path, "r");
        StringBuilder res = new StringBuilder();
        int b = file.read();

        while(b != -1){
            res.append((char)b);
            b = file.read();
        }
        file.close();

        return res.toString();
    }


    public String readFrom(int numberSymbol) throws IOException {

        file = new RandomAccessFile(path, "r");
        StringBuilder res = new StringBuilder();


        file.seek(numberSymbol);
        int b = file.read();


        while(b != -1){
            res.append((char)b);

            b = file.read();
        }
        file.close();

        return res.toString();
    }


    public void write(String st) throws IOException {

        file = new RandomAccessFile(path, "rw");

        file.write(st.getBytes("cp1251"));

        file.close();
    }

}
