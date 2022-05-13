package org.example.task_2;

public class CensoredText {

    private final String wordToHide;

    public CensoredText(String wordToHide) {
        this.wordToHide = wordToHide;
    }

    public String getWordToHide() {
        return wordToHide;
    }

    public String censor(String text) {
        return text.replaceAll(this.wordToHide, "censored");
    }
}