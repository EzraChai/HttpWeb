package com;

import com.entity.state;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testJson {
    public static void main(String[] args) {
        state State = new state();
        State.setId(5);
        State.setName("Negeri Sembilan");
        State.setAbbreviation("NSN");
        State.setCapital("Seremban");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(State);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
