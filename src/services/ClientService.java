package services;

import models.Client;

public interface ClientService {
    public boolean login(String username, String password);

    public void register(Client client);

}

