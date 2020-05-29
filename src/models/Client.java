package models;

import readwrite.write.Writer;

public class Client extends Person {
    private String username;
    private String password;
    int id;
    private final Writer audit = new Writer();

    public Client(String lastName, String firstName, int year, int month, int day, String username, String password) {
        super(lastName, firstName, year, month, day);
        this.username = username;
        this.password = password;
    }

    public Client(String lastName, String firstName, int year, int month, int day) {
        super(lastName, firstName, year, month, day);
        username = "";
        password = "";
    }

    public Client() {
        username = "";
        password = "";
        id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client: " + username + " " + password;
    }
}

