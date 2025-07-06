package ch.timor.projects.simpletimelogger.model;

import java.util.*;

public class UserDataBase {
    private final Map<String, User> userStorage = new HashMap<>();
    private Collection<UserDataBaseListener> listenerCollection = new ArrayList<>();

    public UserDataBase() {
    }

    public void addUser(User user) {
        if(!(user == null)) {
            this.userStorage.put(user.getUserName(), user);
            this.fireRegisterEvent(new RegisterEvent(this, user.getUserName(), user.getPassword()));
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

    public void addUserDataBaseListener(UserDataBaseListener listener) {
        this.listenerCollection.add(listener);
    }

    public void removeUserDataBaseListener(UserDataBaseListener listener) {
        this.listenerCollection.add(listener);
    }

    private void fireRegisterEvent(EventObject event) {
        for(UserDataBaseListener listener: listenerCollection) {
            listener.handleRegisterEvent(event);
        }
    }
}
