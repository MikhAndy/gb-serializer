package ru.andrey.serializer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.andrey.deserializer.JsonDeserializer;
import ru.andrey.deserializer.XmlDeserializer;
import ru.andrey.users.User;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.util.ArrayList;


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
        JsonSerializer serializer = new JsonSerializer();
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
        User pavel = new User(1,"Pavel", "pavel@mail.ru");
        User andrey = new User(2,"Andrey", "andrey@gmail.com");
        User alexander = new User(3,"Alexander", "alexander@yandex.ru");
        User natasha = new User(4,"Natasha", "natasha@gmail.com");
        User anna = new User(5,"Anna", "anna@mail.ru");
        User sergey = new User(6,"Sergey", "sergey@rambler.ru");
        User mikhail = new User(7,"Mikhail", "maikhail@rambler.ru");
        User mike = new User(8,"Mike", "mike@gmail.com");
        User bob = new User(9,"Bob", "bob@rambler.ru");
        User dmitriy = new User(10,"Dmitriy", "dmitriy@yandex.ru");

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