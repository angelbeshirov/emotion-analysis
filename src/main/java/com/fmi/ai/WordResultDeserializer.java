package com.fmi.ai;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WordResultDeserializer extends StdDeserializer<WordResult> {

    private final ObjectMapper objectMapper;

    public WordResultDeserializer() {
        this(null);
    }

    protected WordResultDeserializer(Class<?> vc) {
        super(vc);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public WordResult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Helper helper = objectMapper.readValue(node.get(0).get("meta").toString(), Helper.class);
        return new WordResult(
                helper.getStems(),
                helper.getSynonyms()
                        .stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList()),
                helper.getAntonyms()
                        .stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList()));
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Helper {
        private List<String> stems;
        private List<List<String>> synonyms;
        private List<List<String>> antonyms;

        public Helper() {
        }

        @JsonGetter("stems")
        public List<String> getStems() {
            return stems;
        }

        @JsonSetter("stems")
        public void setStems(List<String> stems) {
            this.stems = stems;
        }

        @JsonGetter("syns")
        public List<List<String>> getSynonyms() {
            return synonyms;
        }

        @JsonSetter("syns")
        public void setSynonyms(List<List<String>> synonyms) {
            this.synonyms = synonyms;
        }

        @JsonGetter("ants")
        public List<List<String>> getAntonyms() {
            return antonyms;
        }

        @JsonSetter("ants")
        public void setAntonyms(List<List<String>> antonyms) {
            this.antonyms = antonyms;
        }
    }
}
