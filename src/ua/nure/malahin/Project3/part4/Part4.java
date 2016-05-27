package ua.nure.malahin.Project3.part4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by sergey on 25.05.16.
 */
public class Part4 {

    public static String hash(String input, String hashType) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(hashType);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (byte i : hash) {
            if (i>0) {
                sb.append(Integer.toHexString(i));
            }else{
                sb.append(Integer.toHexString(i).substring(Integer.toHexString(i).length() - 2, Integer.toHexString(i).length()).toUpperCase());
            }
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password to hash", "SHA-256"));
        System.out.println(hash("password to hash", "SHA-256"));
    }
}
