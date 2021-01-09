package service;

import bl.ConnectionDB;
import dao.BusDAO;
import entity.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusService extends ConnectionDB implements BusDAO {

    Connection connection = getConnection();

    @Override
    public Bus getById(Long id) {

        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM bus WHERE bus_id=?";

        Bus bus = new Bus();
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            bus.setId(resultSet.getLong("bus_id"));
            bus.setMark(resultSet.getString("mark"));
            bus.setLicencePlate(resultSet.getString("licence_plate"));
            bus.setSeats(resultSet.getInt("seats"));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

            try{

                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();

            }catch(SQLException e){
                e.printStackTrace();
            }

        }

        return bus;
    }

    @Override
    public void add(Bus bus) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO bus (bus_id, mark, licence_plate, seats) VALUES (?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, bus.getId());
            preparedStatement.setString(2, bus.getMark());
            preparedStatement.setString(3, bus.getLicencePlate());
            preparedStatement.setInt(4, bus.getSeats());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {

            try{

                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();

            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Bus> getAll() {

        List<Bus> busesList = new ArrayList<>();
        String sql = "SELECT * FROM bus";
        Statement statement = null;

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Bus bus = new Bus();
                bus.setId(resultSet.getLong("bus_id"));
                bus.setMark(resultSet.getString("mark"));
                bus.setLicencePlate(resultSet.getString("licence_plate"));
                bus.setSeats(resultSet.getInt("seats"));

                busesList.add(bus);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {

            try{

                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return busesList;
    }

    @Override
    public void update(Bus bus) {

        PreparedStatement preparedStatement = null;
        String sql = "UPDATE bus SET mark=?, licence_plate=?, seats=? WHERE bus_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bus.getMark());
            preparedStatement.setString(2, bus.getLicencePlate());
            preparedStatement.setInt(3, bus.getSeats());
            preparedStatement.setLong(4, bus.getId());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {

            try{

                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    @Override
    public void remove(Bus bus) {

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM bus WHERE bus_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, bus.getId());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {

            try{

                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }
}
