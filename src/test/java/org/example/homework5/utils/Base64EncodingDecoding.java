package org.example.homework5.utils;

import java.util.Base64;

public class Base64EncodingDecoding {

    public static String encode (String input) {
        if (input == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String decode (String encodedString) {
        if (encodedString == null) {
            return null;
        }
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
