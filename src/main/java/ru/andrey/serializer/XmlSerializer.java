package ru.andrey.serializer;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.io.IOException;

public class XmlSerializer {

    public File serialize(UserCollection userCollection, String filename) {
        XmlMapper mapper = new XmlMapper();
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
