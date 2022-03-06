package com.company;
import java.util.Set;
import java.util.TreeMap;

public class SortingWords {
    private StringBuilder[] words;
    private Integer[] key_count;
    private int count_words;

    private class Swap{
        void swap_integer(int index){
            int swap_int;
            swap_int = key_count[index];
            key_count[index] = key_count[++index];
            key_count[index] = swap_int;
        }
        void swap_string_builder(int index){
            final int START_INDEX = 0;
            StringBuilder swap_string=new StringBuilder();
                    swap_string.append(words[index].toString());
                    words[index].delete(START_INDEX, words[index].length());
                    words[index].append(words[++index].toString());
                    words[index].delete(START_INDEX, words[index].length());
                    words[index].append(swap_string.toString());
        }
    }



    void sorting(java.util.Scanner scanner_files_names) {
        final int STARTING_COUNT = 0;
        final int CELL_OFFSET = 1;

        StringParser parser = new StringParser();
        parser.string_parser(scanner_files_names);

        TreeMap<String, Integer> sorting_words = parser.sorting_words();
        Set<String> keys = sorting_words.keySet();

        count_words = parser.count_words();
        key_count = new Integer[keys.size()];
        words = new StringBuilder[keys.size()];

        int count = STARTING_COUNT;
        for (String key : keys) {
            key_count[count] =  sorting_words.get(key);
            words[count] = new StringBuilder(key);
            count++;
        }

        Swap swap=new Swap();
        for (int out = words.length - CELL_OFFSET; out > STARTING_COUNT; out--) {
            for (int in = STARTING_COUNT; in < out; in++) {

                if (key_count[in] > key_count[in+CELL_OFFSET]) {

                    swap.swap_integer(in);
                    swap.swap_string_builder(in);

                }

            }
        }
    }

    public StringBuilder[] words(){
        return words;
    }
    public Integer[] key_count(){
        return key_count;
    }
    public int count_words(){
        return count_words;
    }

}
