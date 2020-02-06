package com.fmi.ai.api;

public interface APICaller {

    double search(String word, String[] dictionaryWords);

    double search(String[] words);

    double search(String word);
}
