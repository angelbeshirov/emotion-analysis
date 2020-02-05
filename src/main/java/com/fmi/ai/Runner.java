package com.fmi.ai;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Runner {

    public static void main(String... args) throws IOException {
        System.out.println("Hello world");
        RestCaller restCaller = new RestCaller();
        Analyzer analyzer = new Analyzer();
        analyzer.analyze("a set of words that is complete in itself, typically containing a subject and predicate, conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one or more subordinate clauses");
        WordResult result = restCaller.call("sad"); // contains the result from the api call
        String s = "";
        try {
            System.out.println(BingAPICaller.search("sad", "boy"));
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
