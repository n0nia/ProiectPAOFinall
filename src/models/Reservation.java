package models;


public class Reservation {
    private Performance performance;
    private int nrOfSeats;
    private Client client;
    int id;

    public Client getClient() {
        return client;
    }

    public Reservation(Performance performance, int nrOfSeats) {
        this.performance = performance;
        this.nrOfSeats = nrOfSeats;
        id = -1;
    }

    public Reservation(Performance performance, int nrOfSeats, Client client) {
        this.performance = performance;
        this.nrOfSeats = nrOfSeats;
        this.client = client;
    }

    public Reservation(Performance performance, Client client, int nrOfSeats, int id) {
        this.performance = performance;
        this.nrOfSeats = nrOfSeats;
        this.client = client;
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reservation(){}

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + performance.toString() + " " + nrOfSeats;
    }
}