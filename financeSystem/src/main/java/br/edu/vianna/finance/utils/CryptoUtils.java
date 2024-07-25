package br.edu.vianna.finance.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtils {
    public static String md5(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(value.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        String generatedHash = sb.toString();
        byte[] hashBytes = md.digest(generatedHash.getBytes());
        String base64EncodedHash = Base64.getEncoder().encodeToString(hashBytes);

        return base64EncodedHash;
    }
}
