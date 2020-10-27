package ru.andrey.serializer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.andrey.deserializer.JsonDeserializer;
import ru.andrey.deserializer.XmlDeserializer;
import ru.andrey.users.User;
import ru.andrey.users.UserCollection;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class SerializerDeserializerTest {

    @Test
    public void testJsonSerializer() {
        UserCollection userCollection = prepareTestData();
        File jsonFile = new File("users.json");
        JsonSerializer serializer = new JsonSerializer();
        serializer.serialize(userCollection, jsonFile.getName());
        Assertions.assertTrue(jsonFile.exists());
        Assertions.assertTrue(jsonFile.length() > 0);
    }

    @Test
    public void testJsonDeserializer() {
        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        UserCollection deserialize = jsonDeserializer.deserialize("F:\\GB\\gb-serializer\\users.json");
        Assertions.assertNotNull(deserialize);
    }

    @Test
    public void testXmlSerializer() {
        UserCollection userCollection = prepareTestData();
        File xmlFile = new File("users.xml");
        XmlSerializer serializer = new XmlSerializer();
        serializer.serialize(userCollection, xmlFile.getName());
        Assertions.assertTrue(xmlFile.exists());
        Assertions.assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testXmlDeserializer() {
        XmlDeserializer xmlDeserializer = new XmlDeserializer();
        UserCollection deserialize = xmlDeserializer.deserialize("F:\\GB\\gb-serializer\\users.xml");
        Assertions.assertNotNull(deserialize);
    }


    private UserCollection prepareTestData() {
        User pavel = new User();
        pavel.setId(1);
        pavel.setName("Pavel");
        pavel.setEmail("pavel@mail.ru");

        User andrey = new User();
        pavel.setId(2);
        pavel.setName("Andrey");
        pavel.setEmail("andrey@gmail.com");

        User alexander = new User();
        pavel.setId(3);
        pavel.setName("Alexander");
        pavel.setEmail("alexander@yandex.ru");

        User natasha = new User();
        pavel.setId(4);
        pavel.setName("Natasha");
        pavel.setEmail("natasha@gmail.com");

        User anna = new User();
        pavel.setId(3);
        pavel.setName("Anna");
        pavel.setEmail("anna@mail.ru");

        User sergey = new User();
        pavel.setId(3);
        pavel.setName("Sergey");
        pavel.setEmail("sergey@rambler.ru");

        User mikhail = new User();
        pavel.setId(3);
        pavel.setName("Mikhail");
        pavel.setEmail("maikhail@rambler.ru");

        User mike = new User();
        pavel.setId(3);
        pavel.setName("Mike");
        pavel.setEmail("mike@gmail.com");

        User bob = new User();
        pavel.setId(3);
        pavel.setName("Bob");
        pavel.setEmail("bob@rambler.ru");

        User dmitriy = new User();
        pavel.setId(3);
        pavel.setName("Dmitriy");
        pavel.setEmail("dmitriy@yandex.ru");

        UserCollection userCollection = new UserCollection();
        userCollection.setUsers(new ArrayList<>());

        userCollection.getUsers().add(pavel);
        userCollection.getUsers().add(andrey);
        userCollection.getUsers().add(alexander);
        userCollection.getUsers().add(natasha);
        userCollection.getUsers().add(anna);
        userCollection.getUsers().add(sergey);
        userCollection.getUsers().add(mikhail);
        userCollection.getUsers().add(mike);
        userCollection.getUsers().add(bob);
        userCollection.getUsers().add(dmitriy);

        return userCollection;
    }
}