package com.fmi.ai.lexicon;

import com.fmi.ai.SpellChecker;
import com.fmi.ai.StopWordsRemover;
import com.fmi.ai.analyze.Analyzer;

/**
 * @author angel.beshirov
 */
public class LexiconAnalyzer implements Analyzer {
    private Lexicon lexicon;
    private final static String LEXICON_PATH = "src\\main\\resources\\lexicon.tsv";

    private final SpellChecker spellChecker;

    public LexiconAnalyzer() {
        this.lexicon = new Lexicon(LEXICON_PATH);
        this.spellChecker = new SpellChecker();
        String k = "";
    }

    @Override
    public LexiconResult analyze(String sentence) {
        LexiconResult result = new LexiconResult();

        try {
            sentence = StopWordsRemover.process(sentence);
//            List<String> words = SyntaxAnalysisAPICaller.process(sentence);

        String[] words = sentence.split("\\s+");

            for (String word : words) {
                word = spellChecker.correct(word);

                LexiconEntry entry = lexicon.get(word);

                if (entry != null) {
                    result.addToAfraid(entry.getAfraid());
                    result.addToAmused(entry.getAmused());
                    result.addToAngry(entry.getAngry());
                    result.addToAnnoyed(entry.getAnnoyed());
                    result.addToHappy(entry.getHappy());
                    result.addToInspired(entry.getInspired());
                }
            }
        } catch (Exception e) {
            System.out.println("Error from syntax analyzer!" + e.getMessage());
        }

        return result;
    }
}
