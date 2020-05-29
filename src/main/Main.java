package main;

import models.*;
import readwrite.read.ClientReader;
import readwrite.read.SeatReader;
import readwrite.read.PerformanceReader;
import readwrite.write.ObjectWriter;
import repositories.ClientRepository;
import services.AdminService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Actor[] actors = new Actor[2];
        actors[0] = new Actor();
        actors[0].setFirstName("Chris");
        actors[1] = new Actor();
        actors[1].setFirstName("Jennifer");
        Calendar a = Calendar.getInstance();
        a.set(2019, 5, 19);

        Date date = a.getTime();

        ArrayList<Seat> availableSeats = new ArrayList<Seat>(6);
        availableSeats.add(0, new Standard(13, 3));
        availableSeats.add(1, new Standard(16, 4));
        availableSeats.add(2, new Balcony(9, 1));
        availableSeats.add(3, new Balcony(6, 1));
        availableSeats.add(4, new Loge(7, 2));
        availableSeats.add(5, new Loge(8, 2));

        Client client1 = new Client("A", "B", 1999, 3, 1, "client1", "parola");
        Client client2 = new Client("C", "D", 2000, 5, 3, "client2", "parola");
        Client client3 = new Client("C", "D", 1998, 7, 3, "client3", "parola");
        Client client4 = new Client("C", "D", 2001, 10, 3, "client4", "parola");

        ClientRepository clientRepository= new ClientRepository();

        Client client = clientRepository.selectClient("client1", "parola");
        System.out.println(client.toString());

        ClientReader clientReader = new ClientReader();
        ClientReader.readData();
        Admin.getAdmin();
        ArrayList<Client> list = new ArrayList<Client>(ClientReader.getClientList());
        Admin.setClients(list);

        SeatReader seatReader = new SeatReader();
        SeatReader.readData();

        ObjectWriter writer = new ObjectWriter();

        ArrayList<Client> list2 = Admin.getClients();
        for (Client i : list2) {
            writer.writeData(i, "client");
            System.out.println(i);
        }

        PerformanceReader performanceReader = new PerformanceReader();
        PerformanceReader.readData();

        Performance performance = PerformanceReader.getPerformanceList().get(0);

        ArrayList<Seat> seatList = new ArrayList<>();
        seatList.add(SeatReader.getSeatList().get(0));
        seatList.add(SeatReader.getSeatList().get(1));

        AdminService adminService = new AdminService();
    }

}

