package com.fmi.ai;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sentence {
    @JsonProperty("relations")
    public List<Relation> relations = new ArrayList<Relation>();

    @JsonProperty("tokens")
    public List<SyntaxToken> tokens = new ArrayList<SyntaxToken>();

    public Boolean isSubject(String str) {
        return this.relations.stream().anyMatch(r -> r.getSubject().equals(str));
    }

    private void removeSubjects() {
        this.tokens = this.tokens.stream().filter(token -> !isSubject(token.getText())).collect(Collectors.toList());
    }

    private void removePronouns() {
        this.tokens = this.tokens.stream().filter(token -> !token.isPronoun()).collect(Collectors.toList());
    }

    private void removePunctuation() {
        this.tokens = this.tokens.stream().filter(token -> !token.isPunctuation()).collect(Collectors.toList());
    }

    private void removeNegations() {
        for(int i = 0; i < tokens.size(); i++) {
            SyntaxToken token = tokens.get(i);
            if(token.getPartOfSpeechTag() == SyntaxToken.PartOfSpeech.NEGATION) {
                // if current token is negation search for the first adjective or verb following it
                int index = getNext(i);
                if(index != -1) {
                    // add not in front of the verb/adjective
                    token.setContent("not " + tokens.get(index).getText());
                    // remove the positive token
                    tokens.remove(index);
                }
            }
        }
    }

    private int getNext(int pos) {
        for(int i = pos + 1; i < tokens.size(); i++) {
            SyntaxToken token = tokens.get(i);
            if(token.getPartOfSpeechTag() == SyntaxToken.PartOfSpeech.ADJECTIVE
                || token.getPartOfSpeechTag() == SyntaxToken.PartOfSpeech.VERB) {
                return i;
            }
        }
        return -1;
    }

    public List<String> getWords() {
        this.removePunctuation();
        this.removePronouns();
        this.removeSubjects();
        this.removeNegations();
        return StopWordsRemover.process(
                this.tokens.stream().map(token -> token.getText()).collect(Collectors.toList()));
    }
}
