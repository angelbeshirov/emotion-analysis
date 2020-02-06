package com.fmi.ai.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @author angel.beshirov
 */
public class GoogleAPICaller implements APICaller {

    private static final String URL = "https://www.googleapis.com/customsearch/v1?key={0}&cx=013698310139606318238%3As2cmwdqrvyq&q={1}&fbclid=IwAR3ZhJX3gGUhay5P1kovZp7w1f2bfhn10iDY1Wt9N8oK6gsYKHpY1xoLBn4";
    private static final String[] KEYS = new String[]{"AIzaSyBIq1R9Au_dTPj80CFMm8xsJjfthsD_O20",
            "AIzaSyAwlZtdYoCFfUIDZaHQHd1FJZqAUol4Udo",
            "AIzaSyBIq1R9Au_dTPj80CFMm8xsJjfthsD_O20",
            "AIzaSyCexNB0A08GkPqbl40ceRUSz8X1jnd5dTw"};

    public double search(String word, String[] dictionaryWords) {
        if (dictionaryWords.length > 9 || dictionaryWords.length == 0) {
            System.out.println("Max parameters size is 10");
            return 0.0d;
        }

        StringBuilder sb = new StringBuilder(word);
        sb.append(" AROUND(10) (").append(dictionaryWords[0]).append(" | ");
        for (int i = 1; i < dictionaryWords.length - 1; i++) {
            sb.append(dictionaryWords[i]).append(" | ");
        }

        if (dictionaryWords.length > 1) {
            sb.append(dictionaryWords[dictionaryWords.length - 1]);
        }

        sb.append(")");

        String searchQuery = URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);

        String builtUrl = MessageFormat.format(URL, KEYS[1], searchQuery);

        try {
            URL url = new URL(builtUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return responseNode.get("queries").get("request").get(0).get("totalResults").asDouble();
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }

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

        String searchQuery = URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);

        String builtUrl = MessageFormat.format(URL, KEYS[1], searchQuery);

        try {
            URL url = new URL(builtUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return responseNode.get("queries").get("request").get(0).get("totalResults").asDouble();
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL " + e.getMessage());
            return 0.0d;
        }
    }

    public double search(String word) {
        String builtUrl = MessageFormat.format(URL, KEYS[1], word);
        try {
            URL url = new URL(builtUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).useDelimiter("\\A").next();
            ObjectNode responseNode = new ObjectMapper().readValue(response, ObjectNode.class);
            return responseNode.get("queries").get("request").get(0).get("totalResults").asDouble();
        } catch (IOException e) {
            System.out.println("Exception from the BING API CALL" + e.getMessage());
            return 0.0d;
        }
    }


}
