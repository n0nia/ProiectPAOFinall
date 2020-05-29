package services;

import models.Client;
import readwrite.write.Writer;
import repositories.ClientRepository;


public class
ClientServiceImpl implements ClientService {
    private final Writer audit = new Writer();
    private static ClientRepository clientRepository = new ClientRepository();

    public boolean login(String username, String password) {
//        audit.writeData("ClientServiceImpl", "login");
        Client client = clientRepository.selectClient(username, password);
        if (client.getId() > 0)
            return true;
        return false;
    }

    public boolean existingUsername(String username) {
        Client client = clientRepository.selectClient(username);
        if (client.getId() > 0) return true;
        return false;
    }

    public void register(Client client) {
        clientRepository.saveClient(client);
        audit.writeData("ClientServiceImpl", "register");

    }


}
