package com.fmi.ai;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StopWordsRemover {
    private static final String WORDS_FILE_PATH = "src\\main\\resources\\stop_words.txt";

    /**
     * Removes stop words from string
     *
     * @param str the input string which will be processed
     * @return a string formed by the input string be removing the stop words
     * @throws Exception
     */
    public static String proceess(String str) {
        String delimiters = "[\\s-\\\\t,;.?!:@\\\\[\\\\](){}_*/]+";
        List<String> words = Arrays.asList(str.split(delimiters));
        List<String> stopWords = StopWordsRemover.readStopWords();
        return String.join(" ",
                words.stream().filter(w -> search(w, stopWords) == -1).collect(Collectors.toList()));
    }

    /**
     * Fetches the stop words from the file they are stored
     *
     * @return array containing the stop words from the file
     */
    private static List<String> readStopWords() {
        List<String> stopWords = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(WORDS_FILE_PATH));
            while (sc.hasNext()) {
                stopWords.add(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    /**
     * Performs binary search over string array
     *
     * @param word  word to be searched in the array
     * @param words array of words
     * @return the index of the searched element in the array or
     * -1 if the element is not contained in the array
     */
    private static int search(String word, List<String> words) {
        word = word.toLowerCase();
        int start = 0, end = words.size() - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            int cmp = word.compareTo(words.get(middle));

            if (cmp == 0) {
                return middle;
            }

            if (cmp > 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
