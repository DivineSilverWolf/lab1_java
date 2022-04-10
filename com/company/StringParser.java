package com.company;
import java.util.TreeMap;
public class StringParser {

    private final String regex="[^\\s\\Q?,.;:()<>!*{}[]\\E\\\"]+";

    private final int COUNT_WORD_ADD=1;
    private final int START_COUNT=0;

    private int count_words;
    private TreeMap<String,Integer> word_and_amount = new TreeMap<>();

    public void stringParsing(java.util.Scanner scanner_files_names) {

        ReaderFileTXT reader = new ReaderFileTXT();
        reader.reading(scanner_files_names);
        String file_text=reader.giveFileText();
        java.util.regex.Pattern SENTENCE_PATTERN = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = SENTENCE_PATTERN.matcher(file_text);
        count_words=START_COUNT;
        while (matcher.find()) {
            String word = matcher.group();
            if (word_and_amount.containsKey(word))
                word_and_amount.put(word, word_and_amount.get(word) + COUNT_WORD_ADD);
            else
                word_and_amount.put(word, COUNT_WORD_ADD);
            count_words++;
        }
    }


    public TreeMap<String,Integer> sortingWords(){
        return word_and_amount;
    }
    public int countWords(){
        return count_words;
    }
}
