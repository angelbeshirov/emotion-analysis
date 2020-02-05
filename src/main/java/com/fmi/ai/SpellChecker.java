package com.fmi.ai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author angel.beshirov
 */
public class SpellChecker {

    private final Map<String, Integer> nWords = new HashMap<>();
    private final static String file = "src\\main\\resources\\big.txt";

    public SpellChecker() {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            Pattern p = Pattern.compile("\\w+");
            for (String temp = ""; temp != null; temp = in.readLine()) {
                Matcher m = p.matcher(temp.toLowerCase());
                while (m.find()) nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
            }
        } catch (IOException e) {
            System.out.println("Error while opening text for creating corpus for word correction!");
        }
    }

    private List<String> edits(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) result.add(word.substring(0, i) + word.substring(i + 1));
        for (int i = 0; i < word.length() - 1; ++i)
            result.add(word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + word.substring(i + 2));
        for (int i = 0; i < word.length(); ++i)
            for (char c = 'a'; c <= 'z'; ++c)
                result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i + 1));
        for (int i = 0; i <= word.length(); ++i)
            for (char c = 'a'; c <= 'z'; ++c)
                result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
        return result;
    }

    public final String correct(String word) {
        if (nWords.containsKey(word)) return word;
        List<String> list = edits(word);
        HashMap<Integer, String> candidates = new HashMap<Integer, String>();
        for (String s : list) if (nWords.containsKey(s)) candidates.put(nWords.get(s), s);
        if (candidates.size() > 0) return candidates.get(Collections.max(candidates.keySet()));
        for (String s : list) for (String w : edits(s)) if (nWords.containsKey(w)) candidates.put(nWords.get(w), w);
        return candidates.size() > 0 ? candidates.get(Collections.max(candidates.keySet())) : word;
    }

}
