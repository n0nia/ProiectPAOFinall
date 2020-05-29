package models;

import readwrite.write.Writer;

public class Actor extends Person {
    private String description;
    private int idActor;
    private final Writer audit = new Writer();

    public Actor(String lastName, String firstName, int year, int month, int day, String description) {
        super(lastName, firstName, year, month, day);
        this.description = description;
        audit.writeData("Actor", "constructor");
    }

    public Actor(String lastName, String firstName, String description, int idActor){
        super(lastName, firstName);
        this.description = description;
        this.idActor = idActor;
    }
    public Actor(String lastName, String firstName, int year, int month, int day) {
        super(lastName, firstName, year, month, day);
        description = "";
    }

    public Actor() {
        description = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

}
