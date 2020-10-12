package ru.andrey.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.io.IOException;

public class JsonSerializer implements UserSerializer {

    public File serialize(UserCollection userCollection, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter objectWriter = mapper.writerFor(UserCollection.class);
        File file = new File(filename);
        try {
            objectWriter.writeValue(file, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
