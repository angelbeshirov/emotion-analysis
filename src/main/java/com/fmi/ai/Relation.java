package com.fmi.ai;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Relation {
    private String subject;
    private String object;
    private String verb;
    private String adverbialPhrase;

    @JsonGetter("subject")
    public String getSubject() {
        return subject;
    }

    @JsonGetter("object")
    public String getObject() {
        return object;
    }

    @JsonGetter("verb")
    public String getVerb() {
        return verb;
    }

    @JsonGetter("adverbialPhrase")
    public String getAdverbialPhrase() {
        return adverbialPhrase;
    }

    @JsonSetter("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonSetter("object")
    public void setObject(String object) {
        this.object = object;
    }

    @JsonSetter("verb")
    public void setVerb(String verb) {
        this.verb = verb;
    }

    @JsonSetter("adverbialPhrase")
    public void setAdverbialPhrase(String adverbialPhrase) {
        this.adverbialPhrase = adverbialPhrase;
    }

    public Relation() {
    }


}
