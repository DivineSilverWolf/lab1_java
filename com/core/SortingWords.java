package com.core;
import java.util.Set;
import java.util.TreeMap;

public class SortingWords {
    private final int STARTING_COUNT = 0;
    private final int CELL_OFFSET = 1;


    private PairWordNumber[] wordsAndNumbers;
    private int countWords;

    void sorting(java.util.Scanner scannerFilesNames) {

        StringParser parser = new StringParser();
        parser.stringParsing(scannerFilesNames);

        TreeMap<String, Integer> sortingWords = parser.sortingWords();
        Set<String> keys = sortingWords.keySet();

        wordsAndNumbers=new PairWordNumber[keys.size()];
        countWords = parser.countWords();

        int count = STARTING_COUNT;
        for (String key : keys) {
            wordsAndNumbers[count]=new PairWordNumber(key,sortingWords.get(key));
            count++;
        }

        for (int out = wordsAndNumbers.length - CELL_OFFSET; out > STARTING_COUNT; out--) {
            for (int in = STARTING_COUNT; in < out; in++) {

                if (wordsAndNumbers[in].returnWordCount() > wordsAndNumbers[in+CELL_OFFSET].returnWordCount()) {

                    PairWordNumber tmp=wordsAndNumbers[in];
                    wordsAndNumbers[in]=wordsAndNumbers[in+CELL_OFFSET];
                    wordsAndNumbers[in+CELL_OFFSET]=tmp;
                }

            }
        }
    }

    public PairWordNumber[] wordsAndNumbers(){
        return wordsAndNumbers;
    }
    public int countWords(){
        return countWords;
    }

}