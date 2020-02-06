package com.fmi.ai;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author angel.beshirov
 */
public class ReferenceWords {
    private final Set<String> joyWords;
    private final Set<String> sadnessWords;

    private final Set<String> surprisedWords;
    private final Set<String> anticipationWords;

    private final Set<String> trustWords;
    private final Set<String> doubtWords;

    private final Set<String> loveWords;
    private final Set<String> hateWords;

    private final Set<String> confidentWords;
    private final Set<String> fearWords;

    private final Set<String> calmWords;
    private final Set<String> angryWords;

    public ReferenceWords() {
        this.joyWords = new HashSet<>();
        this.sadnessWords = new HashSet<>();
        this.surprisedWords = new HashSet<>();
        this.anticipationWords = new HashSet<>();
        this.trustWords = new HashSet<>();
        this.doubtWords = new HashSet<>();
        this.loveWords = new HashSet<>();
        this.hateWords = new HashSet<>();
        this.confidentWords = new HashSet<>();
        this.fearWords = new HashSet<>();
        this.calmWords = new HashSet<>();
        this.angryWords = new HashSet<>();
    }

    public void addJoyWord(String... words) {
        for (String word : words) {
            if (joyWords.size() <= 90) {
                joyWords.add(word);
            }
        }
    }

    public void addSadWord(String... words) {
        for (String word : words) {
            if (sadnessWords.size() <= 90) {
                sadnessWords.add(word);
            }
        }
    }

    public void addSurprisedWord(String... words) {
        for (String word : words) {
            if (surprisedWords.size() <= 90) {
                surprisedWords.add(word);
            }
        }
    }

    public void addAnticipationWord(String... words) {
        for (String word : words) {
            if (anticipationWords.size() <= 90) {
                anticipationWords.add(word);
            }
        }
    }

    public void addTrustWord(String... words) {
        for (String word : words) {
            if (trustWords.size() <= 90) {
                trustWords.add(word);
            }
        }
    }

    public void addDoubtWord(String... words) {
        for (String word : words) {
            if (doubtWords.size() <= 90) {
                doubtWords.add(word);
            }
        }
    }

    public void addLoveWords(String... words) {
        for (String word : words) {
            if (loveWords.size() <= 90) {
                loveWords.add(word);
            }
        }
    }

    public void addHateWord(String... words) {
        for (String word : words) {
            if (hateWords.size() <= 90) {
                hateWords.add(word);
            }
        }
    }

    public void addConfidentWord(String... words) {
        for (String word : words) {
            if (confidentWords.size() <= 90) {
                confidentWords.add(word);
            }
        }
    }

    public void addFearWord(String... words) {
        for (String word : words) {
            if (fearWords.size() <= 90) {
                fearWords.add(word);
            }
        }
    }

    public void addCalmWord(String... words) {
        for (String word : words) {
            if (calmWords.size() <= 90) {
                calmWords.add(word);
            }
        }
    }

    public void addAngryWord(String... words) {
        for (String word : words) {
            if (angryWords.size() <= 90) {
                angryWords.add(word);
            }
        }
    }

    public Set<String> getJoyWords() {
        return joyWords;
    }

    public Set<String> getSadnessWords() {
        return sadnessWords;
    }

    public Set<String> getSurprisedWords() {
        return surprisedWords;
    }

    public Set<String> getAnticipationWords() {
        return anticipationWords;
    }

    public Set<String> getTrustWords() {
        return trustWords;
    }

    public Set<String> getDoubtWords() {
        return doubtWords;
    }

    public Set<String> getLoveWords() {
        return loveWords;
    }

    public Set<String> getHateWords() {
        return hateWords;
    }

    public Set<String> getConfidentWords() {
        return confidentWords;
    }

    public Set<String> getFearWords() {
        return fearWords;
    }

    public Set<String> getCalmWords() {
        return calmWords;
    }

    public Set<String> getAngryWords() {
        return angryWords;
    }

    @Override
    public String toString() {
        return "ReferenceWords{" + '\n' +
                "joyWords=" + joyWords.size() + '\n' +
                "sadnessWords=" + sadnessWords.size() + '\n' +
                "surprisedWords=" + surprisedWords.size() + '\n' +
                "anticipationWords=" + anticipationWords.size() + '\n' +
                "trustWords=" + trustWords.size() + '\n' +
                "doubtWords=" + doubtWords.size() + '\n' +
                "loveWords=" + loveWords.size() + '\n' +
                "hateWords=" + hateWords.size() + '\n' +
                "confidentWords=" + confidentWords.size() + '\n' +
                "fearWords=" + fearWords.size() + '\n' +
                "calmWords=" + calmWords.size() + '\n' +
                "angryWords=" + angryWords.size() + '\n' +
                '}';
    }
}
