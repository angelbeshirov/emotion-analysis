package com.fmi.ai;

import java.util.Scanner;

public class Runner {

    public static void main(String... args)  {

        Analyzer analyzer = new BingStatisticalAnalyzer();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter a String:");
            String input = sc.nextLine();
            analyzer.analyze(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
