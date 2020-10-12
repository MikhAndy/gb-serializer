package ru.andrey.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.io.IOException;

public class XmlDeserializer implements UserDeserializer {
    public UserCollection deserialize(String filename) {
        XmlMapper mapper = new XmlMapper();
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
