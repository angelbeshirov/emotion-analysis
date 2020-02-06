package com.fmi.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author angel.beshirov
 */
public class BingStatisticalAnalyzer implements Analyzer {

    private final SpellChecker spellChecker;
    private final ReferenceWords referenceWords;
    private final RestCaller restCaller;

    public BingStatisticalAnalyzer() {
        this.spellChecker = new SpellChecker();
        this.referenceWords = new ReferenceWords();
        this.restCaller = new RestCaller();
        initReferenceWords();
        enlargeReferenceWords();


        System.out.println("Testing spell checker:");
        System.out.println(spellChecker.correct("saaad"));
    }

    public void enlargeReferenceWords() {
        // it is a set in reference words will handle duplicates;
        System.out.println("Size before enlarging:\n" + referenceWords.toString());
        System.out.println("Enlarging joy-sad reference words...");
        List<String> newJoyWords = new ArrayList<>();
        List<String> newSadWords = new ArrayList<>();
        for (String word : referenceWords.getJoyWords()) {
            WordResult wordResult = restCaller.call(word);
            newJoyWords.addAll(wordResult.getStems());
            newJoyWords.addAll(wordResult.getSynonyms());
            newSadWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getSadnessWords()) {
            WordResult wordResult = restCaller.call(word);
            newSadWords.addAll(wordResult.getStems());
            newSadWords.addAll(wordResult.getSynonyms());
            newJoyWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addJoyWord(newJoyWords.toArray(new String[0]));
        referenceWords.addSadWord(newSadWords.toArray(new String[0]));

        System.out.println("Enlarging surprised-anticipation reference words...");
        List<String> newSurprisedWords = new ArrayList<>();
        List<String> newAnticipationWords = new ArrayList<>();
        for (String word : referenceWords.getSurprisedWords()) {
            WordResult wordResult = restCaller.call(word);
            newSurprisedWords.addAll(wordResult.getStems());
            newSurprisedWords.addAll(wordResult.getSynonyms());
            newAnticipationWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getAnticipationWords()) {
            WordResult wordResult = restCaller.call(word);
            newAnticipationWords.addAll(wordResult.getStems());
            newAnticipationWords.addAll(wordResult.getSynonyms());
            newSurprisedWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addSurprisedWord(newSurprisedWords.toArray(new String[0]));
        referenceWords.addAnticipationWord(newAnticipationWords.toArray(new String[0]));

        System.out.println("Enlarging trust-doubt reference words...");
        List<String> newTrustWords = new ArrayList<>();
        List<String> newDoubtWords = new ArrayList<>();
        for (String word : referenceWords.getTrustWords()) {
            WordResult wordResult = restCaller.call(word);
            newTrustWords.addAll(wordResult.getStems());
            newTrustWords.addAll(wordResult.getSynonyms());
            newDoubtWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getDoubtWords()) {
            WordResult wordResult = restCaller.call(word);
            newDoubtWords.addAll(wordResult.getStems());
            newDoubtWords.addAll(wordResult.getSynonyms());
            newTrustWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addTrustWord(newTrustWords.toArray(new String[0]));
        referenceWords.addDoubtWord(newDoubtWords.toArray(new String[0]));


        System.out.println("Enlarging love-hate reference words...");
        List<String> newLoveWords = new ArrayList<>();
        List<String> newHateWords = new ArrayList<>();
        for (String word : referenceWords.getLoveWords()) {
            WordResult wordResult = restCaller.call(word);
            newLoveWords.addAll(wordResult.getStems());
            newLoveWords.addAll(wordResult.getSynonyms());
            newHateWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getHateWords()) {
            WordResult wordResult = restCaller.call(word);
            newHateWords.addAll(wordResult.getStems());
            newHateWords.addAll(wordResult.getSynonyms());
            newLoveWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addLoveWords(newLoveWords.toArray(new String[0]));
        referenceWords.addHateWord(newHateWords.toArray(new String[0]));

        System.out.println("Enlarging confidence-fear reference words...");
        List<String> newConfidentWords = new ArrayList<>();
        List<String> newFearWords = new ArrayList<>();
        for (String word : referenceWords.getConfidentWords()) {
            WordResult wordResult = restCaller.call(word);
            newConfidentWords.addAll(wordResult.getStems());
            newConfidentWords.addAll(wordResult.getSynonyms());
            newFearWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getConfidentWords()) {
            WordResult wordResult = restCaller.call(word);
            newFearWords.addAll(wordResult.getStems());
            newFearWords.addAll(wordResult.getSynonyms());
            newConfidentWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addConfidentWord(newConfidentWords.toArray(new String[0]));
        referenceWords.addFearWord(newFearWords.toArray(new String[0]));

        System.out.println("Enlarging calm-angry reference words...");
        List<String> newCalmWords = new ArrayList<>();
        List<String> newAngryWords = new ArrayList<>();
        for (String word : referenceWords.getCalmWords()) {
            WordResult wordResult = restCaller.call(word);
            newCalmWords.addAll(wordResult.getStems());
            newCalmWords.addAll(wordResult.getSynonyms());
            newAngryWords.addAll(wordResult.getAntonyms());
        }

        for (String word : referenceWords.getAngryWords()) {
            WordResult wordResult = restCaller.call(word);
            newAngryWords.addAll(wordResult.getStems());
            newAngryWords.addAll(wordResult.getSynonyms());
            newCalmWords.addAll(wordResult.getAntonyms());
        }

        referenceWords.addCalmWord(newCalmWords.toArray(new String[0]));
        referenceWords.addAngryWord(newAngryWords.toArray(new String[0]));

        System.out.println("Size after enlarging:\n" + referenceWords.toString());
    }

    public EmotionResult analyze(String sentence) {
        sentence = StopWordsRemover.proceess(sentence);

        EmotionResult emotionResult = new EmotionResult();
        try {
            String[] words = sentence.split("\\s+");

            for (String word : words) {
                word = spellChecker.correct(word);

                System.out.println("Going to make a call for" + word);
                //word = spellChecker.correct(word);
                //System.out.println("Corrected:" + word);

                // calculate for joy-sad score for each word
                setUpJoyScore(emotionResult, word);
                setUpSurprisedScore(emotionResult, word);
                // TODO same for the other 4, just gotta fix the API to return responses faster
            }
        } catch (Exception e) {
            System.out.println("GOTTA SLEEP CUZ THE API RETURNS 429 2 many requests");
        }

        return emotionResult;
    }

    private void setUpJoyScore(EmotionResult emotionResult, String word) throws InterruptedException {
        double joyScore = 0.0d;
        double sadScore = 0.0d;
        double onlyWord = BingAPICaller.search(word);
        System.out.println("Joy words:" + referenceWords.getJoyWords().size());
        System.out.println("Starting to execute requests for joy words");
        for (String positiveReferenceWord : referenceWords.getJoyWords()) {
            double wordAndP = BingAPICaller.search(word, positiveReferenceWord);
            double onlyP = BingAPICaller.search(positiveReferenceWord);
            joyScore += Math.log(wordAndP / (onlyP * onlyWord));
            Thread.sleep(1000);
        }

        System.out.println("Starting to execute requests for sad words");
        for (String negativeReferenceWord : referenceWords.getSadnessWords()) {
            double wordAndN = BingAPICaller.search(word, negativeReferenceWord);
            double onlyP = BingAPICaller.search(negativeReferenceWord);
            sadScore += Math.log(wordAndN / (onlyP * onlyWord));
            Thread.sleep(1000); // 0.5 sec
        }

        System.out.println("Score for joy-sad axis is:" + (joyScore - sadScore));

        emotionResult.addJoyScore(joyScore - sadScore);
    }

    private void setUpSurprisedScore(EmotionResult emotionResult, String word) throws InterruptedException {
        double surprisedScore = 0.0d;
        double anticipatedScore = 0.0d;
        double onlyWord = BingAPICaller.search(word);
        System.out.println("Surprised words:" + referenceWords.getSurprisedWords().size());
        System.out.println("Starting to execute requests for surprised words");
        for (String positiveReferenceWord : referenceWords.getSurprisedWords()) {
            double wordAndP = BingAPICaller.search(word, positiveReferenceWord);
            double onlyP = BingAPICaller.search(positiveReferenceWord);
            surprisedScore += Math.log(wordAndP / (onlyP * onlyWord));
            Thread.sleep(1000); // API returns 403/429
        }

        System.out.println("Starting to execute requests for anticipated words");
        for (String negativeReferenceWord : referenceWords.getAnticipationWords()) {
            double wordAndN = BingAPICaller.search(word, negativeReferenceWord);
            double onlyP = BingAPICaller.search(negativeReferenceWord);
            anticipatedScore += Math.log(wordAndN / (onlyP * onlyWord));
            Thread.sleep(1000); // 0.5 sec
        }

        System.out.println("Score for suprise-anticipated axis is:" + (surprisedScore - anticipatedScore));

        emotionResult.addSurprisedScore(surprisedScore - anticipatedScore);
    }

    private void initReferenceWords() {
        String[] initialJoyWords = {"joy", "delight", "pleasure", "exultation", "glad", "elation", "happy", "thrill", "exultation", "euphoria"};
        String[] initialSadWords = {"sad", "unhappy", "sorrow", "regret", "depressed", "miserable", "dismal", "gloomy", "regret", "downcast"};
        String[] initialSurprisedWords = {"surprised", "shocked", "astonish", "amaze", "speechless", "astounding", "stun", "breathtaking", "staggered", "wonder"};
        String[] initialAnticipationWords = {"anticipate", "await", "expect", "hope", "foresee", "predict", "count on", "look for", "await", "prepare for"};
        String[] initialTrustWords = {"trust", "faith", "certainty", "certitude", "assure", "sureness"};
        String[] initialDoubtWords = {"doubt", "mistrust", "disbelief", "distrust", "uncertainty", "incredulity", "unbelief"};
        String[] initialLoveWords = {"affection", "attachment", " devotedness", "devotion", "fondness", "passion", "crush", "intimacy", "love", "attachment"};
        String[] initialHateWords = {"hate", "hatred", "loathe", "detest", "dislike", "despise", "disrelish", "abominate", "despise", "animosity"};
        String[] initialConfidentWords = {"confident", "assured", " bold", "convinced", "courageous", "fearless", "hopeful", "positive"};
        String[] initialFearWords = {"fear", "angst", "anxiety", "despair", "dismay", "worry", "horror", "panic", "scare", "unease"};
        String[] initialCalmWords = {"calm", "calmness", " patience", "peace", "eased", "quiet", "restraint", "silence", "tranquility", "stillness"};
        String[] initialAngryWords = {"angry", "annoyed", "bitter", "enraged", "exasperated", "furious", "heated", "irritated", "outraged", "resentful"};

        referenceWords.addJoyWord(initialJoyWords);
        referenceWords.addSadWord(initialSadWords);
        referenceWords.addSurprisedWord(initialSurprisedWords);
        referenceWords.addAnticipationWord(initialAnticipationWords);
        referenceWords.addTrustWord(initialTrustWords);
        referenceWords.addDoubtWord(initialDoubtWords);
        referenceWords.addLoveWords(initialLoveWords);
        referenceWords.addHateWord(initialHateWords);
        referenceWords.addConfidentWord(initialConfidentWords);
        referenceWords.addFearWord(initialFearWords);
        referenceWords.addCalmWord(initialCalmWords);
        referenceWords.addAngryWord(initialAngryWords);
    }
}
