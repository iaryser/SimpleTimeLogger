package ch.timor.projects.simpletimelogger.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDataBase {
    private final Map<String, User> userStorage = new HashMap<>();

    public UserDataBase() {
    }

    public void addUser(User user) {
        if(!(user == null)) {
            this.userStorage.put(user.getUserName(), user);
        }
    }

    public void removeUser(String userName) {
        if(this.userStorage.get(userName) == null) {
            throw new IllegalArgumentException("Kein User mit Usernamen: " + userName + " gefunden.");
        }
        this.userStorage.remove(userName);
    }

    public User getUser(String userName) {
        if(this.userStorage.get(userName) == null) {
            throw new IllegalArgumentException("Kein User mit Usernamen: " + userName + " gefunden.");
        }
        return this.userStorage.get(userName);
    }

    public int getAmountOfUsers() {
        return this.userStorage.size();
    }

    public Collection<User> getAllUsers() {
        Collection<User> userCollection = new ArrayList<>();
        for(User user : userStorage.values()) {
            userCollection.add(user);
        }
        return userCollection;
    }
}
