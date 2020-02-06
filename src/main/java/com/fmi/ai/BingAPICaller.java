package com.fmi.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BingAPICaller {
    private static final String SUBSCRIPTION_KEY = "719e20f1da604ac0a453e54cd0627cf9";
    private static final String HOST_URL = "https://ai-search.cognitiveservices.azure.com";
    private static final String PATH = "/bing/v7.0/search";

    public static Double search(String word, String dictionaryWord) {
        try {
            URL url = new URL(HOST_URL + PATH + "?q=" + URLEncoder.encode(word + " & " + dictionaryWord, StandardCharsets.UTF_8));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return Double.valueOf(responseNode.get("webPages").get("totalEstimatedMatches").toString());
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }

    public static Double search(String word) {
        try {
            URL url = new URL(HOST_URL + PATH + "?q=" + URLEncoder.encode(word, StandardCharsets.UTF_8));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return Double.valueOf(responseNode.get("webPages").get("totalEstimatedMatches").toString());
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }
}
