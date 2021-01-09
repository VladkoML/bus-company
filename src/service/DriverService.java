package service;

import bl.ConnectionDB;
import dao.DriverDAO;
import entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverService extends ConnectionDB implements DriverDAO {

    Connection connection = getConnection();

    @Override
    public Driver getById(Long id) {

        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM bus WHERE driver_id=?";
        Driver driver = new Driver();

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            driver.setId(resultSet.getLong("driver_id"));
            driver.setFullName(resultSet.getString("full_name"));
            driver.setBirthday(resultSet.getDate("birthday"));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
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
        return driver;
    }

    @Override
    public void add(Driver driver) {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO driver (driver_id, full_name, birthday) VALUES (?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, driver.getId());
            preparedStatement.setString(2, driver.getFullName());
            preparedStatement.setDate(3, driver.getBirthday());

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
    public List<Driver> getAll() {

        List<Driver> drivers = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM driver";

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Driver driver = new Driver();
                driver.setId(resultSet.getLong("driver_id"));
                driver.setFullName(resultSet.getString("full_name"));
                driver.setBirthday(resultSet.getDate("birthday"));

                drivers.add(driver);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

            try {

                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return  drivers;
    }

    @Override
    public void update(Driver driver) {

        PreparedStatement preparedStatement = null;
        String sql = "UPDATE driver SET full_name=?, birthday=? WHERE driver_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, driver.getFullName());
            preparedStatement.setDate(2, driver.getBirthday());
            preparedStatement.setLong(3, driver.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
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
    public void remove(Driver driver) {

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM driver WHERE driver_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, driver.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
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
