package org.example;

public class CensoredText {

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
        return text.replaceAll(this.wordToHide, "censored");
    }
}