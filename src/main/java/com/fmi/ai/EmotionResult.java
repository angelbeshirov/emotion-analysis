package com.fmi.ai;

import com.fmi.ai.analyze.Result;

/**
 * @author angel.beshirov
 */
public class EmotionResult implements Result {
    /**
     * Emotional axis joy-sadness
     */
    private double joyScore;

    /**
     * Emotional axis surprise-anticipation
     */
    private double surprisedScore;
    /**
     * Emotional axis trust-doubt
     */
    private double trustScore;

    /**
     * love-hatred/hate/detest
     */
    private double loveScore;

    /**
     * Emotional axis for confident-fear
     */
    private double confidentScore;

    /**
     * Emotional axis for calm-angry
     */
    private double calmScore;

    public EmotionResult() {
    }

    public double getJoyScore() {
        return joyScore;
    }

    public void setJoyScore(double joyScore) {
        this.joyScore = joyScore;
    }

    public double getSurprisedScore() {
        return surprisedScore;
    }

    public void setSurprisedScore(double surprisedScore) {
        this.surprisedScore = surprisedScore;
    }

    public double getTrustScore() {
        return trustScore;
    }

    public void setTrustScore(double trustScore) {
        this.trustScore = trustScore;
    }

    public double getLoveScore() {
        return loveScore;
    }

    public void setLoveScore(double loveScore) {
        this.loveScore = loveScore;
    }

    public double getConfidentScore() {
        return confidentScore;
    }

    public void setConfidentScore(double confidentScore) {
        this.confidentScore = confidentScore;
    }

    public double getCalmScore() {
        return calmScore;
    }

    public void setCalmScore(double calmScore) {
        this.calmScore = calmScore;
    }

    public void addJoyScore(double score) {
        this.joyScore += score;
    }

    public void addSurprisedScore(double score) {
        this.surprisedScore += score;
    }

    public void addTrustScore(double score) {
        this.trustScore += score;
    }

    public void addLoveScore(double score) {
        this.loveScore += score;
    }
    public void addConfidenceScore(double score) {
        this.confidentScore += score;
    }
    public void addCalmScore(double score) {
        this.calmScore += score;
    }


    @Override
    public String toString() {
        return "EmotionResult{" +
                "joyScore=" + joyScore +
                ", surprisedScore=" + surprisedScore +
                ", trustScore=" + trustScore +
                ", loveScore=" + loveScore +
                ", confidentScore=" + confidentScore +
                ", calmScore=" + calmScore +
                '}';
    }
}
