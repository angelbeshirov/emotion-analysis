package com.fmi.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class BingAPICaller {
    private static final String SUBSCRIPTION_KEY = "719e20f1da604ac0a453e54cd0627cf9";
    private static final String HOST_URL = "https://ai-search.cognitiveservices.azure.com";
    private static final String PATH = "/bing/v7.0/search";

    public static Integer search(String word, String dictionaryWord) throws Exception {
        URL url = new URL(HOST_URL + PATH + "?q=" +  URLEncoder.encode(word + " & " + dictionaryWord, "UTF-8"));
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();
        ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
        return Integer.parseInt(responseNode.get("webPages").get("totalEstimatedMatches").toString());
    }
}
