package com.core;

public class PairWordNumber {
    private String word;
    private Integer wordCount;
    public PairWordNumber(String word,Integer wordCount){
        this.word=word;
        this.wordCount=wordCount;
    }
    public String returnWord(){
        return word;
    }
    public Integer returnWordCount(){
        return wordCount;
    }
}
