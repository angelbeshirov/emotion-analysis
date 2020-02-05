package com.fmi.ai;

/**
 *
 * TODO not final emotional axis
 * @author angel.beshirov
 */
public class EmotionResult {
    /**
     * Emotional axe happy-sad
     */
    private double happyScore;
    /**
     * pleased-miserable
     */
    private double pleasedScore;

    /**
     * excited-bored/depressed
     */
    private double excitedScore;

    /**
     * relaxed-tense???
     */
    private double relaxedScore;

    /**
     * scared-confident
     */
    private double scaredScore;

    /**
     * love-hatred/hate/detest
     */
    private double loveScore;

    public EmotionResult() {
    }

    public EmotionResult(double happyScore,
                         double pleasedScore,
                         double excitedScore,
                         double relaxedScore,
                         double scaredScore,
                         double loveScore) {
        this.happyScore = happyScore;
        this.pleasedScore = pleasedScore;
        this.excitedScore = excitedScore;
        this.relaxedScore = relaxedScore;
        this.scaredScore = scaredScore;
        this.loveScore = loveScore;
    }
}
