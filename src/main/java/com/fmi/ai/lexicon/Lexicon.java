package com.fmi.ai.lexicon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author angel.beshirov
 */
public class Lexicon {
    private static final String DELIMITER = "\t";
    private final Map<String, LexiconEntry> lexicon;

    private static final int WORD_INDEX = 0;
    private static final int AFRAID_INDEX = 1;
    private static final int AMUSED_INDEX = 2;
    private static final int ANGRY_INDEX = 3;
    private static final int ANNOYED_INDEX = 4;
    private static final int DO_NOT_CARE_INDEX = 5; // not used
    private static final int HAPPY_INDEX = 6;
    private static final int INSPIRED_INDEX = 7;
    private static final int SAD_INDEX = 8;
    private static final int FREQ_INDEX = 9;

    public Lexicon(String path) {
        File file = new File(path);
        lexicon = new HashMap<>();
        populateLexicon(file);
    }

    private void populateLexicon(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // have to read the first garbage line
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                LexiconEntry lexiconEntry = new LexiconEntry(
                        Double.parseDouble(data[AFRAID_INDEX]),
                        Double.parseDouble(data[AMUSED_INDEX]),
                        Double.parseDouble(data[ANGRY_INDEX]),
                        Double.parseDouble(data[ANNOYED_INDEX]),
                        Double.parseDouble(data[HAPPY_INDEX]),
                        Double.parseDouble(data[INSPIRED_INDEX]),
                        Double.parseDouble(data[SAD_INDEX]),
                        Double.parseDouble(data[FREQ_INDEX])
                );
                lexicon.put(data[WORD_INDEX], lexiconEntry);
            }
        } catch (IOException e) {
            System.out.println("Error while opening the lexicon! " + e.getMessage());
        }
    }

    public LexiconEntry get(String word) {
        return lexicon.get(word);
    }
}
