package org.example;

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
        if ((text == null) || (text.isBlank())) {
            return text;
        }

        return replaceIgnoreCase(text);
    }

    private String replaceIgnoreCase(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = text.split(" ");
        String word = this.wordToHide.toLowerCase();

        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            if (words[i].toLowerCase().contains(word)) {
                words[i] = changeWord(words[i].toLowerCase().split(word));
            }

            stringBuilder.append(words[i]).append(' ');
        }

        return stringBuilder.toString().trim();
    }

    private static String changeWord(String[] parts) {
        if (parts.length == 0) {
            return PUT_INSTEAD;
        }

        StringBuilder sb = new StringBuilder().append(parts[0]).append(PUT_INSTEAD);

        return (parts.length > 1) ? sb.append(parts[1]).toString() : sb.toString();
    }
}