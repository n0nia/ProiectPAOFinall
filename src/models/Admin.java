package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    private static Admin admin;
    private HashMap<Client, Reservation> reservations;
    private ArrayList<Client> clients;
    private ArrayList<Performance> performances;
    private Theatre theatre;

    private Admin(){
        clients = new ArrayList<>();
        reservations = new HashMap<>();
        performances = new ArrayList<>();
    }

    public static Admin getAdmin() {
        if (admin == null)
            admin = new Admin();
        return admin;
    }

    public static HashMap<Client, Reservation> getReservations() {
        return admin.reservations;
    }

    public static void setReservations(HashMap<Client, Reservation> reservations) {
        admin.reservations = reservations;
    }

    public static ArrayList<Client> getClients() {
        return admin.clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        if(admin.clients.size() == 0){
            admin.clients = new ArrayList<>(clients);
        }else admin.clients.addAll(clients);
    }

    public static ArrayList<Performance> getSpectacles() {
        return admin.performances;
    }

    public static void setSpectacles(ArrayList<Performance> performances) {
        admin.performances = performances;
    }

    public static Theatre getTheatre() {
        return admin.theatre;
    }

    public static void setTheatre(Theatre theatre) {
        admin.theatre = theatre;
    }
}
