package models;

import java.util.*;


public class Person {
    private String lastName;
    private String firstName;
    private Date dateOfBirth;

    Person(String lastName, String firstName, int year, int month, int day) {
        this.lastName = lastName;
        this.firstName = firstName;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        dateOfBirth = cal.getTime();
    }

    Person() {
        lastName = "";
        firstName = "";
        dateOfBirth = new Date();
    }

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
