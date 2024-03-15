package Serialization.Libraries;

import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
import DomainArea.Cookbook;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;


public class ObjectMap {
    public String json = "";

    public String serializeToJson(Cookbook book) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            json = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

    public Cookbook deserializeJson(String resultJson) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Cookbook newBook = objectMapper.readValue(resultJson, Cookbook.class);
            // deserializedString = "Рецепт: " + newBook.getTextRecipes();
            return newBook;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}