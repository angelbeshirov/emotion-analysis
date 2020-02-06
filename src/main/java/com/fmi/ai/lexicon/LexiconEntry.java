package com.fmi.ai.lexicon;

/**
 * Entry for the DepecheMood lexicon. DONT_CARE score is ignored, sad score
 * is put into the happy score with negative sign.
 *
 * @author angel.beshirov
 */
public class LexiconEntry {

    private final double afraid;
    private final double amused;
    private final double angry;
    private final double annoyed;
    private final double happy; // happy - sad
    private final double inspired;
    private final double frequency;

    public LexiconEntry(double afraid, double amused, double angry, double annoyed, double happy, double inspired, double frequency) {
        this.afraid = afraid;
        this.amused = amused;
        this.angry = angry;
        this.annoyed = annoyed;
        this.happy = happy;
        this.inspired = inspired;
        this.frequency = frequency;
    }

    public double getAfraid() {
        return afraid;
    }

    public double getAmused() {
        return amused;
    }

    public double getAngry() {
        return angry;
    }

    public double getAnnoyed() {
        return annoyed;
    }

    public double getHappy() {
        return happy;
    }

    public double getInspired() {
        return inspired;
    }

    public double getFrequency() {
        return frequency;
    }
}
