package com.fmi.ai.lexicon;

import com.fmi.ai.analyze.Result;

/**
 * @author angel.beshirov
 */
public class LexiconResult implements Result {

    private double afraid;
    private double amused;
    private double angry;
    private double annoyed;
    private double happy;
    private double inspired;
    private double sad;

    public LexiconResult() {
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

    public double getSad() {
        return sad;
    }

    public void setAfraid(double afraid) {
        this.afraid = afraid;
    }

    public void setAmused(double amused) {
        this.amused = amused;
    }

    public void setAngry(double angry) {
        this.angry = angry;
    }

    public void setAnnoyed(double annoyed) {
        this.annoyed = annoyed;
    }

    public void setHappy(double happy) {
        this.happy = happy;
    }

    public void setInspired(double inspired) {
        this.inspired = inspired;
    }

    public void setSad(double sad) {
        this.sad = sad;
    }

    public void addToAfraid(double x) {
        afraid += x;
    }

    public void addToAmused(double x) {
        amused += x;
    }

    public void addToAngry(double x) {
        angry += x;
    }

    public void addToAnnoyed(double x) {
        annoyed += x;
    }

    public void addToHappy(double x) {
        happy += x;
    }

    public void addToInspired(double x) {
        inspired += x;
    }

    public void addToSad(double x) {
        sad += x;
    }


    @Override
    public String toString() {
        double sum = Math.sqrt(afraid * afraid + amused * amused + angry * angry + annoyed * annoyed + happy * happy + inspired * inspired + sad * sad);

        return "LexiconResult{" +
                "afraid=" + afraid / sum +
                ", amused=" + amused / sum +
                ", angry=" + angry / sum +
                ", annoyed=" + annoyed / sum +
                ", happy=" + happy / sum +
                ", inspired=" + inspired / sum +
                ", sad=" + sad / sum +
                '}';
    }
}
