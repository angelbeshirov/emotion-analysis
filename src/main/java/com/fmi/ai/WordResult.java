package com.fmi.ai;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = WordResultDeserializer.class)
public class WordResult {

    private List<String> stems;
    private List<String> synonyms;
    private List<String> antonyms;

    public WordResult() {
        this.stems = new ArrayList<>();
        this.synonyms = new ArrayList<>();
        this.antonyms = new ArrayList<>();
    }

    public WordResult(List<String> stems, List<String> synonyms, List<String> antonyms) {
        this.stems = stems;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public List<String> getStems() {
        return stems;
    }

    public void setStems(List<String> stems) {
        this.stems = stems;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }
}
