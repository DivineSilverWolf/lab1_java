package com.company;
import java.util.TreeMap;
public class StringParser {

    private int count_words;
    private TreeMap<String,Integer> word_and_amount = new TreeMap<>();
    public void string_parser(java.util.Scanner scanner_files_names) {
        final String regex="[^\\s\\Q?,.;:()<>!*{}[]\\E\\\"]+";
        final int COUNT_WORD_ADD=1;

        ReadFileTXT reading = new ReadFileTXT();
        reading.reading(scanner_files_names);
        String file_text=reading.give_file_text();
        java.util.regex.Pattern SENTENCE_PATTERN = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = SENTENCE_PATTERN.matcher(file_text);

        final int START_COUNT=0;
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


    public TreeMap<String,Integer> sorting_words(){
        return word_and_amount;
    }
    public int count_words(){
        return count_words;
    }
}
