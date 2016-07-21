package ua.nure.malahin.Practice4;

/**
 * Created by sergey on 25.05.16.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    private static final String ENCODING = "utf8";
    private static final String EOL = "\n";

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {        
            if(fileName == null) {
        	throw new IOException();
            }
            Scanner scanner = new Scanner(new File(fileName), ENCODING);

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(EOL);
            }

        } catch (IOException ex) {
            return null;
        }
            return sb.toString().trim();

    }
    
    public static void callIOException(String string) throws IOException{
	if (getInput(string)==null){
	    throw new IOException();
	}
    }
}
