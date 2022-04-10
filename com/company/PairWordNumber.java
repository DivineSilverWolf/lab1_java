package com.company;

public class PairWordNumber {
    private String word;
    private Integer word_count;
    public PairWordNumber(String word,Integer word_count){
        this.word=word;
        this.word_count=word_count;
    }
    public String returnWord(){
        return word;
    }
    public Integer returnWordCount(){
        return word_count;
    }
}
