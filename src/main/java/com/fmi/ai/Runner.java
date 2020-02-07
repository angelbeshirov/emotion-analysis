package com.fmi.ai;

import com.fmi.ai.analyze.Analyzer;
import com.fmi.ai.analyze.Result;
import com.fmi.ai.lexicon.LexiconAnalyzer;

import java.util.Scanner;

public class Runner {

    public static void main(String... args) {

        //Analyzer analyzer = new BingStatisticalAnalyzer();

        Analyzer anal = new LexiconAnalyzer();
        try (Scanner sc = new Scanner(System.in)) {

            // lexicon based
            System.out.println("Please enter a sentence to analyze for lexicon analyzer:");
            String input = sc.nextLine();
            Result emotionResult = anal.analyze(input);
            System.out.println(emotionResult.toString());


            // api calls
//            APICaller apiCaller = new BingAPICaller(); // change here to bing/google
//            Analyzer analyzer = new GramaticalProximityAnalyzer(apiCaller);
//            System.out.println("Please enter a sentence to analyze for bing/google analyzer:");
//            String input = sc.nextLine();
//            Result emotionResult = analyzer.analyze(input);
//            System.out.println(emotionResult.toString());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
