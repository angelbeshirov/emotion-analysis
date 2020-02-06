package com.fmi.ai;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SyntaxToken {
    @JsonProperty("text")
    private Text text;
    @JsonProperty("partOfSpeechTag")
    private String partOfSpeechTag;
    @JsonProperty("lemma")
    private String lemma;

    public SyntaxToken() {
    }

    @JsonGetter("text")
    public String getText() {
        return text.content;
    }

    @JsonSetter("text")
    public void setText(Text text) {
        this.text = text;
    }

    public PartOfSpeech getPartOfSpeechTag() {
        return this.stringToPoS(partOfSpeechTag);
    }

    public Boolean isPunctuation() {
        return this.stringToPoS(this.partOfSpeechTag) == null;
    }

    @JsonSetter("partOfSpeechTag")
    public void setPartOfSpeech(String partOfSpeechTag) {
        this.partOfSpeechTag = partOfSpeechTag;
    }

    @JsonGetter("lemma")
    public String getLemma() {
        return lemma;
    }

    @JsonSetter("lemma")
    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public void setContent(String content) {
        this.text.content = content;
    }

    public Boolean isPronoun() {
        return stringToPoS(this.partOfSpeechTag) == PartOfSpeech.PRONOUN;
    }

    private PartOfSpeech stringToPoS(String str) {
        switch (str) {
            case "NN":
            case "NNS":
            case "NR":
                return PartOfSpeech.NOUN;
            case "XNOT":
                return PartOfSpeech.NEGATION;
            case "JJ":
                return PartOfSpeech.ADJECTIVE;
            case  "PN":
                return PartOfSpeech.PRONOUN;
            case "VB":
            case "VBN":
                return PartOfSpeech.VERB;
            case "RB":
                return PartOfSpeech.ADVERB;
            case "DT":
                return PartOfSpeech.QUESTION_WORD;
            default:
                return null;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Text {
        public Text() { }

        @JsonProperty("content")
        public String content;
    }

    public enum PartOfSpeech {
        NOUN,
        VERB,
        ADJECTIVE,
        ADVERB,
        NEGATION,
        PRONOUN,
        QUESTION_WORD
    }
}
