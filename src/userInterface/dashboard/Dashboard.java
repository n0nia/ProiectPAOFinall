package userInterface.dashboard;

import models.Client;
import userInterface.register.RegisterFrame;

import javax.swing.*;

public class Dashboard {

    public void showDashboard(Client client) {
        Dash frame = new Dash(client);
        frame.setTitle("Dashboard");
        frame.setVisible(true);
        frame.setBounds(100, 50, 370, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
