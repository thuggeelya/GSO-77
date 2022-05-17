package org.example;

import java.util.stream.IntStream;

public class CensoredText {

    private static final String PUT_INSTEAD = "censored";
    private final String wordToHide;

    public CensoredText(String wordToHide) {
        this.wordToHide = wordToHide;
    }

    public String getWordToHide() {
        return wordToHide;
    }

    public String censor(String text) {
        if (isBlank(text) || isBlank(this.wordToHide) || !(text.toLowerCase().contains(this.wordToHide.toLowerCase()))) {
            return text;
        }

        return replace(text);
    }

    private boolean isBlank(String s) {
        return (s == null) || (s.isBlank());
    }

    private String replace(String text) {
        StringBuilder result = new StringBuilder();
        String lowerWordToHide = this.wordToHide.toLowerCase();
        String lowerText = text.toLowerCase();
        int tempIndex;
        int incNumber;

        for (int i = 0; i < lowerText.length();) {
            incNumber = 1;

            if ( ((i == 0) || (!(isAbcOrDgt(lowerText.charAt(i - 1)))) ) && (lowerText.charAt(i) == lowerWordToHide.charAt(0))) {
                tempIndex = i;

                // ищем посимвольное совпадение
                while (lowerText.charAt(tempIndex) == lowerWordToHide.charAt(tempIndex - i)) {
                    if (tempIndex == i + lowerWordToHide.length() - 1) {
                        if ((tempIndex == lowerText.length() - 1) || !(isAbcOrDgt(lowerText.charAt(tempIndex + 1)))) {
                            result.append(PUT_INSTEAD);
                            incNumber = lowerWordToHide.length();
                        } else {
                            IntStream.range(i, tempIndex + 1).forEach(n -> result.append(text.charAt(n)));
                        }

                        break;
                    }

                    tempIndex++;
                }
            } else {
                // иначе записываем текущий символ и идем дальше
                result.append(text.charAt(i));
            }

            // + 1 или + wordToHide.length()
            i += incNumber;
        }

        return result.toString();
    }

    private static boolean isAbcOrDgt(char p) {
        return Character.isAlphabetic(p) || Character.isDigit(p);
    }
}