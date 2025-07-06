package ch.timor.projects.simpletimelogger.model;

import java.util.Objects;

public final class User {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;

    public User(String firstName, String lastName, String userName, String password) {
        if(this.isValid(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.");
        }

        if(userName.length() < 4 || userName.length() > 16) {
            throw new IllegalArgumentException("Username muss zwischen 5 und 16 Zeichen lang sein.");
        }
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Checks for the validity of users password.
     * @param password the password String to validate.
     * @return boolean
     */
    private boolean isValid(String password) {
        if(password.length() < 8 || password.length() > 20) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;

        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                hasDigit = true;
            }
            if(Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if(Character.isLowerCase(c)) {
                hasLower = true;
            }
            if(!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasDigit && hasUpper && hasLower && hasSpecial;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return (object instanceof User user)
                && (Objects.equals(this.userName, user.userName))
                && (Objects.equals(this.password, user.password));
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.userName, this.password);
    }

    @Override
    public String toString() {
        return "User[firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", userName=" + this.userName
                + ", password=" + this.password + "]";
    }
}
