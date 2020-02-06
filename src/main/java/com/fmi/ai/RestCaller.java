package com.fmi.ai;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.MessageFormat;

public class RestCaller {
    private final static String URL_DICTIONARY = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/{0}?key=cf1673c8-5530-4224-9f17-2851ed229613&fbclid=IwAR105dDIvEu-73-RrtsNNohvrKF2dD8jeb8gY_HjiMga7ytpMBeqM1TC4io";

    private final ObjectMapper objectMapper;

    public RestCaller() {
        this.objectMapper = new ObjectMapper();
    }

    public WordResult call(String word) {
        RestTemplate restTemplate = new RestTemplate();
        String url = MessageFormat.format(URL_DICTIONARY, word);
        String result = restTemplate.getForObject(url, String.class);

        try {
            return objectMapper.readValue(result, WordResult.class);
        } catch (IOException e) {
            return new WordResult();
        }
    }
}
