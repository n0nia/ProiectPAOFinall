package readwrite.read;

import com.opencsv.CSVReader;
import models.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ClientReader extends Reader<Client> {

    private static List<Client> clientList = new ArrayList<Client>();

    public static void readData() {

        ClientReader clientReader = new ClientReader();

        clientList = clientReader.readAndCreateObjects(
                "F:\\FMI\\Anul_II\\Sem_2\\PAO\\Proiect-PAO-master\\src\\readwrite\\resources\\Clients.csv");

        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    public static List<Client> getClientList() {
        return Collections.unmodifiableList(clientList);
    }

    @Override
    Client createObject(String[] objectDetails) {

        return new Client(objectDetails[0], objectDetails[1], Integer.parseInt(objectDetails[2]),
                Integer.parseInt(objectDetails[3]), Integer.parseInt(objectDetails[4]), objectDetails[5],
                objectDetails[6]);


    }
}