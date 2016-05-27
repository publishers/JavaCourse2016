package ua.nure.malahin.Project3.part4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by sergey on 25.05.16.
 */
public class HashExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update("password to hash".getBytes());
        byte[] hash = digest.digest();
        System.out.println(Arrays.toString(hash));
        // output: [56, 55, 83, 50, 113, -114, -54, 115, -125, 86, 79, -109, 17, -65, 107, 84]
    }
}
