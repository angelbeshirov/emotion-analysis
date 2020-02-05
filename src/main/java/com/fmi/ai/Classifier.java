package com.fmi.ai;

/**
 * @author angel.beshirov
 */
public class Classifier {

    /**
     * Probability that a word is encountered in a document.
     * All documents with word X in them / all documents
     *
     * @param word the word
     * @return the probability
     */
    public double probabilityWord(String word) {
        return 1 / 2.0;
    }

    /**
     * Probability that word1 is encountered in a document near word 2
     * = log(hits(word1 near word2)/hits(word1) * hits(word2))
     *
     * @param word1 word1
     * @param word2 word2
     * @return the probability
     */
    private double probabilityWordNearWord(String word1, String word2) {
        return 1 / 2.0;
    }
}
