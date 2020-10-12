package ru.andrey.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.io.IOException;

public class JsonDeserializer implements UserDeserializer {
    public UserCollection deserialize(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader objectReader = mapper.readerFor(UserCollection.class);
        UserCollection o = null;
        try {
            o = objectReader.readValue(new File(filename), UserCollection.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}
