package com.fmi.ai.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BingAPICaller implements APICaller {
    private static final String SUBSCRIPTION_KEY = "51cbda7883df4d9cb527ce40df7bb108";
    private static final String HOST_URL = "https://ai-search.cognitiveservices.azure.com";
    private static final String PATH = "/bing/v7.0/search";

    /**
     * Search for word & (x1 | x2 | x3 | ... | x9)
     */
    public double search(String word, String[] dictionaryWords) {
        if (dictionaryWords.length > 9 || dictionaryWords.length == 0) {
            System.out.println("Max parameters size is 10");
            return 0.0d;
        }

        StringBuilder sb = new StringBuilder(word);
        sb.append(" & (").append(dictionaryWords[0]).append(" | ");
        for (int i = 1; i < dictionaryWords.length - 1; i++) {
            sb.append(dictionaryWords[i]).append(" | ");
        }

        if (dictionaryWords.length > 1) {
            sb.append(dictionaryWords[dictionaryWords.length - 1]);
        }

        sb.append(")");

        String builtUrl = HOST_URL + PATH + "?q=" + URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);
        //System.out.println("URL is " + builtUrl);

        try {
            URL url = new URL(builtUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return Double.parseDouble(responseNode.get("webPages").get("totalEstimatedMatches").toString());
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }

    /**
     * Search for (x1 | x2 | x3 | ... | x10)
     */
    public double search(String[] words) {
        if (words.length > 10 || words.length == 0) {
            System.out.println("Max parameters size is 10");
            return 0.0d;
        }

        StringBuilder sb = new StringBuilder(words[0]).append(" | ");
        for (int i = 1; i < words.length - 1; i++) {
            sb.append(words[i]).append(" | ");
        }

        if (words.length > 1) {
            sb.append(words[words.length - 1]);
        }

        String builtUrl = HOST_URL + PATH + "?q=" + URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);
        //System.out.println("URL is " + builtUrl);

        try {
            URL url = new URL(builtUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return Double.parseDouble(responseNode.get("webPages").get("totalEstimatedMatches").toString());
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL " + e.getMessage());
            return 0.0d;
        }
    }

    public double search(String word) {
        try {
            URL url = new URL(HOST_URL + PATH + "?q=" + URLEncoder.encode(word, StandardCharsets.UTF_8));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            System.out.println(response);
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return Double.parseDouble(responseNode.get("webPages").get("totalEstimatedMatches").toString());
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }
}
