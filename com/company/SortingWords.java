package com.company;
import java.util.Set;
import java.util.TreeMap;

public class SortingWords {
    private final int STARTING_COUNT = 0;
    private final int CELL_OFFSET = 1;


    private PairWordNumber[] words_and_numbers;
    private int count_words;

    void sorting(java.util.Scanner scanner_files_names) {

        StringParser parser = new StringParser();
        parser.string_parser(scanner_files_names);

        TreeMap<String, Integer> sorting_words = parser.sorting_words();
        Set<String> keys = sorting_words.keySet();

        words_and_numbers=new PairWordNumber[keys.size()];
        count_words = parser.count_words();

        int count = STARTING_COUNT;
        for (String key : keys) {
            words_and_numbers[count]=new PairWordNumber(key,sorting_words.get(key));
            count++;
        }

        for (int out = words_and_numbers.length - CELL_OFFSET; out > STARTING_COUNT; out--) {
            for (int in = STARTING_COUNT; in < out; in++) {

                if (words_and_numbers[in].return_word_count() > words_and_numbers[in+CELL_OFFSET].return_word_count()) {

                    PairWordNumber tmp=words_and_numbers[in];
                    words_and_numbers[in]=words_and_numbers[in+CELL_OFFSET];
                    words_and_numbers[in+CELL_OFFSET]=tmp;
                }

            }
        }
    }

    public PairWordNumber[] words_and_numbers(){
        return words_and_numbers;
    }
    public int count_words(){
        return count_words;
    }

}