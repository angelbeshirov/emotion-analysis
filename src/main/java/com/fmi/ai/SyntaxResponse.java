package com.fmi.ai;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SyntaxResponse {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    @JsonSetter("sentences")
    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @JsonGetter("sentences")
    public List<Sentence> getSentences() {
        return sentences;
    }
}
