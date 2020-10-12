package ru.andrey.deserializer;

import ru.andrey.users.UserCollection;

import java.io.File;

public interface UserDeserializer {
    UserCollection deserialize(String filename);
}
