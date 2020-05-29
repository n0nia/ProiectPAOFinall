package repositories;

import connectivity.DataBaseConnection;
import models.Client;
import models.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationRepository {
    private DataBaseConnection connection = DataBaseConnection.getDataBaseConnectionInstance();

    public void saveReservation(Reservation reservation) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("insert into reservations " +
                    "(id_performance, id_client, number_of_seats)" +
                    "values(?, ?, ?);");
            statement.setInt(1, reservation.getPerformance().getId());
            statement.setInt(2, reservation.getClient().getId());
            statement.setInt(3, reservation.getNrOfSeats());

            statement.executeUpdate();

            PreparedStatement statement2 = connection.getConnection().prepareStatement("select id_reservation " +
                    "from reservations where id_spectacle = ? and id_client = ?;");
            statement2.setInt(1, reservation.getPerformance().getId());
            statement2.setInt(2, reservation.getClient().getId());

            ResultSet rs = statement2.executeQuery();
            int result = 0;
            while(rs.next()){
                result = rs.getInt("id_reservation");
            }

            reservation.setId(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteReservation(int id) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("delete from reservations where id_reservation = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(Reservation reservation, int newNrOfSeats) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("update reservations " +
                    "set number_of_seats = ? where id_reservation = ?;");
            statement.setInt(1, newNrOfSeats);
            statement.setInt(2, reservation.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Reservation> getReservationsByClient(Client client) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select * from reservations where id_client = ?");
            statement.setInt(1, client.getId());
            ResultSet rs = statement.executeQuery();

            PerformanceRepository performanceRepository = new PerformanceRepository();
            ClientRepository clientRepository = new ClientRepository();

            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setNrOfSeats(rs.getInt("number_of_seats"));
                reservation.setPerformance(performanceRepository.getPerformanceById(rs.getInt("id_spectacle")));
                reservation.setClient(clientRepository.selectClient(rs.getInt("id_client")));
                reservation.setId(rs.getInt("id_reservation"));
                reservations.add(reservation);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;

    }

}
