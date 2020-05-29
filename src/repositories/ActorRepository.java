package repositories;

import connectivity.DataBaseConnection;
import models.Actor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorRepository {
    private DataBaseConnection connection = DataBaseConnection.getDataBaseConnectionInstance();

    public ArrayList<Actor> getAllActors() {
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            String sql = "SELECT * from actors";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor(rs.getString("last_name"), rs.getString("first_name"),
                        rs.getString("description"), rs.getInt("id_actor"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public void saveActor(Actor actor) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("insert into actors" +
                    " (last_name, first_name, description) values(?, ?, ?)");
            statement.setString(1, actor.getLastName());
            statement.setString(2, actor.getFirstName());
            statement.setString(3, actor.getDescription());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateActorDescription(String description, int id){
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("update actors set description = ? where id_actor = ?");
            statement.setInt(2, id);
            statement.setString(1, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(Actor actor) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("delete from actors where id_actor = ?");
            statement.setInt(1, actor.getIdActor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
