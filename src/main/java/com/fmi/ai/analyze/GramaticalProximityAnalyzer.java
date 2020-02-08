package com.fmi.ai.analyze;

import com.fmi.ai.*;
import com.fmi.ai.api.APICaller;

import java.util.*;

/**
 * @author angel.beshirov
 */
public class GramaticalProximityAnalyzer implements Analyzer {

    private double ALL_DOCS = 10_000_000_000_000_000_000d;
    private final SpellChecker spellChecker;
    private final ReferenceWords referenceWords;
    private final RestCaller restCaller;
    private final APICaller apiCaller;
    private static final Random RANDOM = new Random();

    private int totalQueries = 0;

    public GramaticalProximityAnalyzer(APICaller apiCaller) {
        this.spellChecker = new SpellChecker();
        this.referenceWords = new ReferenceWords();
        this.restCaller = new RestCaller();
        this.apiCaller = apiCaller;
        //enlargeReferenceWords();

        System.out.println("Testing spell checker:");
        System.out.println(spellChecker.correct("saaad"));
    }

    public void enlargeReferenceWords() {
        // it is a set in reference words will handle duplicates;
        System.out.println("Size before enlarging:\n" + referenceWords.toString());
        System.out.println("Enlarging joy-sad reference words...");
        List<String> newJoyWords = new ArrayList<>();
        List<String> newSadWords = new ArrayList<>();
        // TODO sort the words in descending order by hits in google/bing (2 many requests not feasible)
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

        EmotionResult emotionResult = new EmotionResult();
        try {
        String[] words = sentence.split("\\s+");
//            List<String> words = SyntaxAnalysisAPICaller.process(sentence);

            for (String word : words) {
                word = spellChecker.correct(word);
                double joyScoreResult, surprisedScoreResult, trustScore, loveScore, confidentScore, calmScore;

                System.out.println("Going to make a call for " + word);
                double onlyWord = apiCaller.search(word);

                System.out.println("Setting up joy score...");
                // ~40 requests
                joyScoreResult = executeQueries(word, referenceWords.getJoyWords(), referenceWords.getSadnessWords(), onlyWord);
                System.out.println("Joy score result:" + joyScoreResult);
                emotionResult.addJoyScore(joyScoreResult);

                System.out.println("Setting up surprised score...");
                surprisedScoreResult = executeQueries(word, referenceWords.getSurprisedWords(), referenceWords.getAnticipationWords(), onlyWord);
                System.out.println("Surprised score result:" + surprisedScoreResult);
                emotionResult.addSurprisedScore(surprisedScoreResult);

                System.out.println("Setting up trust score...");
                trustScore = executeQueries(word, referenceWords.getTrustWords(), referenceWords.getDoubtWords(), onlyWord);
                System.out.println("Trust score result:" + trustScore);
                emotionResult.addTrustScore(trustScore);

                System.out.println("Setting up love score...");
                loveScore = executeQueries(word, referenceWords.getLoveWords(), referenceWords.getHateWords(), onlyWord);
                System.out.println("Love score result:" + loveScore);
                emotionResult.addLoveScore(loveScore);

                System.out.println("Setting up confident score...");
                confidentScore = executeQueries(word, referenceWords.getConfidentWords(), referenceWords.getFearWords(), onlyWord);
                System.out.println("Confident score result:" + confidentScore);
                emotionResult.addConfidenceScore(confidentScore);

                System.out.println("Setting up calm score...");
                calmScore = executeQueries(word, referenceWords.getCalmWords(), referenceWords.getAngryWords(), onlyWord);
                System.out.println("Calm score result:" + calmScore);
                emotionResult.addCalmScore(calmScore);

                System.out.println("Total requests sent:" + totalQueries);
            }
        } catch (Exception e) {
            // swallow e
            System.out.println("Exception from syntax analyzer" + e.getMessage());
        }

        return emotionResult;
    }

    private double executeQueries(String word, Set<String> positiveClass, Set<String> negativeClass, double onlyWord) {
        double score = 1.0d;

        List<List<String>> positiveXiWords = distributeWordsRandomlyIntoLists(new ArrayList<>(positiveClass), 9);
        List<List<String>> negativeXiWords = distributeWordsRandomlyIntoLists(new ArrayList<>(negativeClass), 9);

        // should make 2 * 10 requests
        for (int i = 0; i < positiveXiWords.size() && i < negativeXiWords.size(); i++) {
            String[] positiveArray = positiveXiWords.get(i).toArray(new String[0]);
            String[] negativeArray = negativeXiWords.get(i).toArray(new String[0]);
            double wordAndPxi = apiCaller.search(word, positiveArray) / ALL_DOCS;
            double onlyPxi = apiCaller.search(positiveArray) / ALL_DOCS;

            double wordAndNxi = apiCaller.search(word, negativeArray) / ALL_DOCS;
            double onlyNxi = apiCaller.search(negativeArray) / ALL_DOCS;

            score *= (wordAndPxi * onlyNxi) / (onlyPxi * wordAndNxi);

            totalQueries += 4;
            //positiveScore += Math.log(1.0 + wordAndPxi / (onlyPxi * onlyWord));
        }

        double res = Math.log(score) / Math.log(2.0);
        return res;
    }

    private List<List<String>> distributeWordsRandomlyIntoLists(List<String> words, int size) {
        Set<Integer> usedIndices = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        // somewhat uniformly distributed
        while (usedIndices.size() != words.size()) {
            int index = RANDOM.nextInt(words.size());

            if (!usedIndices.contains(index)) {
                usedIndices.add(index);

                temp.add(words.get(index));
                if (temp.size() >= size) {
                    result.add(temp);
                    temp = new ArrayList<>();
                }
            }
        }

        return result;
    }
}
