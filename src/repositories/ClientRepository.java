package repositories;

import connectivity.DataBaseConnection;
import models.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientRepository {
    private DataBaseConnection connection = DataBaseConnection.getDataBaseConnectionInstance();

    public Client selectClient(int id){
        Client client = new Client();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select * from client_data where username = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                client.setLastName(rs.getString("last_name"));
                client.setFirstName(rs.getString("first_name"));
                client.setDateOfBirth(rs.getDate("date_of_birth"));
                client.setUsername(rs.getString("username"));
                client.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client selectClient(String username){
        Client client = new Client();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select idclient_data from client_data where username = ?");
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                client.setId(rs.getInt("idclient_data"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client selectClient(String username, String password) {
        Client client = new Client();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select last_name, first_name," +
                    " date_of_birth, username, password, idclient_data " +
                    "from client_data where username = ? and password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                client.setLastName(rs.getString(1));
                client.setFirstName(rs.getString(2));
                client.setDateOfBirth(rs.getDate(3));
                client.setUsername(rs.getString(4));
                client.setPassword(rs.getString(5));
                client.setId(rs.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void saveClient(Client client) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("insert into client_data " +
                    "(last_name, first_name, date_of_birth, username, password)" +
                    "values (?, ?, ?, ?, ?);");
            statement.setString(1, client.getLastName());
            statement.setString(2, client.getFirstName());
            java.sql.Date clientDate = convertUtilToSql(client.getDateOfBirth());
            statement.setDate(3, clientDate);
            statement.setString(4, client.getUsername());
            statement.setString(5, client.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Client client) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("delete from client_data where client_id = ?");
            statement.setInt(1, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClientInfo(Client client, String lastName, String firstName){
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("update client_data " +
                    "set last_name = ?, first_name = ? where idclient_data = ?");
            statement.setInt(3, client.getId());
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
