package com.fmi.ai;

/**
 * @author angel.beshirov
 */
public class Analyzer {

    private final SpellChecker spellChecker;
    public Analyzer() {
        this.spellChecker = new SpellChecker();


        System.out.println("Testing spell checker:");
        System.out.println(spellChecker.correct("saaad"));
    }


    public EmotionResult analyze(String sentence) {
        // TODO remove useless words (pronouns)
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            System.out.println(word);
            System.out.println("Corrected:" + spellChecker.correct(word));

            // TODO for each word and for each word from the corpus make a call to the API
            // TODO to calculate the probability
        }

        return new EmotionResult();
    }
}
