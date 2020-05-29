package services;

import models.*;
import readwrite.write.Writer;

import java.util.*;

public class AdminService {
    private final Writer audit = new Writer();

//    public void makeReservation(Client client, Reservation reservation) {
//        if(!isClient(client)){
//            addClient(client);
//        }
//
//        audit.writeData("AdminService", "makeReservation");
//        if (isClient(client)) {
//            Admin.getReservations().put(client, reservation);
//        }
//    }

    private void addClient(Client client) {
        audit.writeData("AdminService", "addClient");
        Admin.getClients().add(client);
    }

//    private boolean isClient(Client client) {
//        audit.writeData("AdminService", "isClient");
//        ClientServiceImpl clientService;
//        clientService = new ClientServiceImpl(client);
//        if(Admin.getClients() == null) return false;
//        for (Client i : Admin.getClients()) {
//            boolean logIn = clientService.login(i.getUsername(), i.getPassword());
//            if (logIn) return true;
//        }
//        return false;
//    }



}
