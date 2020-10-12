package ru.andrey.serializer;

import netscape.security.UserTarget;
import ru.andrey.users.User;
import ru.andrey.users.UserCollection;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface UserSerializer {
    File serialize(UserCollection userCollection, String filename);
}
