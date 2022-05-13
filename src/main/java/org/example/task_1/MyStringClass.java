package org.example.task_1;

import java.util.Arrays;

public class MyStringClass {

    public static String capitalize(String word) {
        if (word == null || word.isBlank()) {
            return "";
        }

        return word.trim().replaceFirst(word.substring(0,1), word.substring(0,1).toUpperCase());
    }

    public static boolean isPalindrome(String word) {
        if (word == null || word.isBlank()) {
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
        if (word == null || word.isBlank()) {
            return "";
        }

        word = makeLatin(word);

        if (word.isBlank()) {
            return "";
        }

        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return new String(wordChars);
    }

    private static String makeLatin(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}