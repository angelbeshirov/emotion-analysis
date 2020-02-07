package com.fmi.ai;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyntaxAnalysisAPICaller {
    private static final String API_URL = "https://api.intellexer.com/analyzeText?apikey=7b63af0d-5602-4389-9372-ab281e1aec1b";

    public static SyntaxResponse analyze(String sentence) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> entity = new HttpEntity<String>(sentence, headers);
        String answer = restTemplate.postForObject(API_URL, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(answer, SyntaxResponse.class);
    }

    public static List<String> process(String sentence) throws Exception {
        List<String> allWords = new ArrayList<>();
        SyntaxResponse resp = SyntaxAnalysisAPICaller.analyze(sentence);
        for(Sentence s : resp.getSentences()) {
            allWords = Stream.concat(allWords.stream(),
                    s.getWords().stream()).collect(Collectors.toList());
        }

        return allWords;
    }
}
