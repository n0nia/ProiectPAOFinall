package repositories;

import connectivity.DataBaseConnection;
import models.Performance;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerformanceRepository {
    private DataBaseConnection connection = DataBaseConnection.getDataBaseConnectionInstance();

    public Performance getPerformanceByTitle(String name){
        Performance performance = new Performance();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select * from performances where title = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                performance.setTitle(rs.getString("title"));
                performance.setLength(rs.getInt("length"));
                performance.setDirector(rs.getString("director"));
                performance.setType(rs.getString("performance_type"));
                performance.setDate(rs.getDate("performance_date"));
                performance.setId(rs.getInt("id_performance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performance;
    }


    public Performance getPerformanceById(int id){
        Performance performance = new Performance();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select * from performances where id_performance = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                performance.setTitle(rs.getString("title"));
                performance.setLength(rs.getInt("length"));
                performance.setDirector(rs.getString("director"));
                performance.setType(rs.getString("performance_type"));
                performance.setDate(rs.getDate("performance_date"));
                performance.setId(rs.getInt("id_performance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performance;
    }

    public ArrayList<Performance> getAllPerformances() {
        ArrayList<Performance> performances = new ArrayList<>();
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("select * from performances");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Performance performance = new Performance();
                performance.setTitle(rs.getString("title"));
                performance.setLength(rs.getInt("length"));
                performance.setDirector(rs.getString("director"));
                performance.setType(rs.getString("performance_type"));
                performance.setDate(rs.getDate("performance_date"));
                performance.setId(rs.getInt("id_performance"));
                performances.add(performance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performances;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void saveSpectacle(Performance performance) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("insert into performances " +
                    "title, director, performance_type, length, performance_date)" +
                    "values(?, ?, ?, ?, ?);");
            statement.setString(1, performance.getTitle());
            statement.setString(2, performance.getDirector());
            statement.setString(3, performance.getType());
            statement.setInt(4, performance.getLength());
            java.sql.Date date = convertUtilToSql(performance.getDate());
            statement.setDate(5, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerformance(Performance performance) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("delete from performances where id_performance = ?");
            statement.setInt(1, performance.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerformanceDate(Performance performance, Date date){
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement("update performances set performance_date = ? where id_performance = ?");
            statement.setInt(2, performance.getId());
            statement.setDate(1, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
