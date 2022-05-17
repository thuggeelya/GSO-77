package org.example;

import java.util.Arrays;

public class MyStringClass {

    public static String capitalize(String word) {
        if (isBlank(word)) {
            return word;
        }

        char[] chars = word.toCharArray();
        String startLetter = "";

        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                startLetter = String.valueOf(chars[i]);
                break;
            } else if (i == chars.length - 1) {
                return word;
            }
        }

        return word.replaceFirst(startLetter, startLetter.toUpperCase());
    }

    public static boolean isPalindrome(String word) {
        if (isBlank(word)) {
            return false;
        }

        String w = word.trim().toLowerCase();

        for (int i = 0; i < w.length()/2; i++) {
            int j = w.length() - 1 - i;

            if (w.charAt(i) != w.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static String alphabetize(String word) {
        if (isBlank(makeLatin(word))) {
            return word;
        }

        char[] wordChars = makeLatin(word).toCharArray();
        Arrays.sort(wordChars);
        return new String(wordChars);
    }

    private static String makeLatin(String word) {
        if (isBlank(word)) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isBlank(String word) {
        return ((word == null) || (word.isBlank()));
    }
}