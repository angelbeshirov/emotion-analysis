package com.fmi.ai;

import java.util.HashSet;
import java.util.Set;

/**
 * @author angel.beshirov
 */
public class ReferenceWords {
    private static final int MAX_SIZE = 90;
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

        initialReferenceWords();
    }

    public void addJoyWord(String... words) {
        for (String word : words) {
            if (joyWords.size() <= MAX_SIZE) {
                joyWords.add(word);
            }
        }
    }

    public void addSadWord(String... words) {
        for (String word : words) {
            if (sadnessWords.size() <= MAX_SIZE) {
                sadnessWords.add(word);
            }
        }
    }

    public void addSurprisedWord(String... words) {
        for (String word : words) {
            if (surprisedWords.size() <= MAX_SIZE) {
                surprisedWords.add(word);
            }
        }
    }

    public void addAnticipationWord(String... words) {
        for (String word : words) {
            if (anticipationWords.size() <= MAX_SIZE) {
                anticipationWords.add(word);
            }
        }
    }

    public void addTrustWord(String... words) {
        for (String word : words) {
            if (trustWords.size() <= MAX_SIZE) {
                trustWords.add(word);
            }
        }
    }

    public void addDoubtWord(String... words) {
        for (String word : words) {
            if (doubtWords.size() <= MAX_SIZE) {
                doubtWords.add(word);
            }
        }
    }

    public void addLoveWords(String... words) {
        for (String word : words) {
            if (loveWords.size() <= MAX_SIZE) {
                loveWords.add(word);
            }
        }
    }

    public void addHateWord(String... words) {
        for (String word : words) {
            if (hateWords.size() <= MAX_SIZE) {
                hateWords.add(word);
            }
        }
    }

    public void addConfidentWord(String... words) {
        for (String word : words) {
            if (confidentWords.size() <= MAX_SIZE) {
                confidentWords.add(word);
            }
        }
    }

    public void addFearWord(String... words) {
        for (String word : words) {
            if (fearWords.size() <= MAX_SIZE) {
                fearWords.add(word);
            }
        }
    }

    public void addCalmWord(String... words) {
        for (String word : words) {
            if (calmWords.size() <= MAX_SIZE) {
                calmWords.add(word);
            }
        }
    }

    public void addAngryWord(String... words) {
        for (String word : words) {
            if (angryWords.size() <= MAX_SIZE) {
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

    private void initialReferenceWords() {
        String[] initialJoyWords = {"joy", "delight", "pleasure", "exultation", "glad", "elation", "happy", "thrill", "exultation", "euphoria"};
        String[] initialSadWords = {"sad", "unhappy", "sorrow", "regret", "depressed", "miserable", "dismal", "gloomy", "regret", "downcast"};
        String[] initialSurprisedWords = {"surprised", "shocked", "astonish", "amaze", "speechless", "astounding", "stun", "breathtaking", "staggered", "wonder"};
        String[] initialAnticipationWords = {"anticipate", "await", "expect", "hope", "foresee", "predict", "count on", "look for", "await", "prepare for"};
        String[] initialTrustWords = {"trust", "faith", "certainty", "certitude", "assure", "sureness"};
        String[] initialDoubtWords = {"doubt", "mistrust", "disbelief", "distrust", "uncertainty", "incredulity", "unbelief", "doubtful"};
        String[] initialLoveWords = {"affection", "attachment", " devotedness", "devotion", "fondness", "passion", "crush", "intimacy", "love", "attachment"};
        String[] initialHateWords = {"hate", "hatred", "loathe", "detest", "dislike", "despise", "disrelish", "abominate", "despise", "animosity"};
        String[] initialConfidentWords = {"confident", "assured", " bold", "convinced", "courageous", "fearless", "hopeful", "positive"};
        String[] initialFearWords = {"fear", "angst", "anxiety", "despair", "dismay", "worry", "horror", "panic", "scare", "unease"};
        String[] initialCalmWords = {"calm", "calmness", " patience", "peace", "eased", "quiet", "restraint", "silence", "tranquility", "stillness"};
        String[] initialAngryWords = {"angry", "annoyed", "bitter", "enraged", "exasperated", "furious", "heated", "irritated", "outraged", "resentful"};

        addJoyWord(initialJoyWords);
        addSadWord(initialSadWords);
        addSurprisedWord(initialSurprisedWords);
        addAnticipationWord(initialAnticipationWords);
        addTrustWord(initialTrustWords);
        addDoubtWord(initialDoubtWords);
        addLoveWords(initialLoveWords);
        addHateWord(initialHateWords);
        addConfidentWord(initialConfidentWords);
        addFearWord(initialFearWords);
        addCalmWord(initialCalmWords);
        addAngryWord(initialAngryWords);
    }
}
