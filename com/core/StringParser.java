package com.core;
import java.util.TreeMap;
public class StringParser {

    private final String regex="[^\\s\\Q?,.;:()<>!*{}[]\\E\\\"]+";

    private final int COUNT_WORD_ADD=1;
    private final int START_COUNT=0;

    private int countWords;
    private TreeMap<String,Integer> wordAndAmount = new TreeMap<>();

    public void stringParsing(java.util.Scanner scannerFilesNames) {

        ReaderFileTXT reader = new ReaderFileTXT();
        reader.reading(scannerFilesNames);
        String fileText=reader.giveFileText();
        java.util.regex.Pattern SENTENCE_PATTERN = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = SENTENCE_PATTERN.matcher(fileText);
        countWords=START_COUNT;
        while (matcher.find()) {
            String word = matcher.group();
            if (wordAndAmount.containsKey(word))
                wordAndAmount.put(word, wordAndAmount.get(word) + COUNT_WORD_ADD);
            else
                wordAndAmount.put(word, COUNT_WORD_ADD);
            countWords++;
        }
    }


    public TreeMap<String,Integer> sortingWords(){
        return wordAndAmount;
    }
    public int countWords(){
        return countWords;
    }
}
