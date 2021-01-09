package service;

import bl.ConnectionDB;
import dao.RouteDAO;
import entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteService extends ConnectionDB implements RouteDAO {

    Connection connection = getConnection();

    @Override
    public Route getById(Long id) {

        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM route WHERE route_id=?";

        Route route = new Route();
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            route.setId(resultSet.getLong("route_id"));
            route.setStartOfRoute(resultSet.getString("start_of_route"));
            route.setEndOfRoute(resultSet.getString("end_pf_route"));
            route.setDepartureDate(resultSet.getDate("departure_date"));
            route.setPrice(resultSet.getFloat("price"));
            route.setBusID(resultSet.getLong("busi"));
            route.setDriverID(resultSet.getLong("driveri"));

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

        return route;
    }

    @Override
    public Route getByDriverAndBusId(Long busID, Long driverID) {

        PreparedStatement preparedStatement = null;
        String sql = "SELECT busi, driveri FROM route WHERE busi=? AND driveri=?";

        Route route = new Route();
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, busID);
            preparedStatement.setLong(2, driverID);

            ResultSet resultSet = preparedStatement.executeQuery();

            route.setId(resultSet.getLong("route_id"));
            route.setStartOfRoute(resultSet.getString("start_of_route"));
            route.setEndOfRoute(resultSet.getString("end_of_route"));
            route.setDepartureDate(resultSet.getDate("departure_date"));
            route.setPrice(resultSet.getFloat("price"));
            route.setBusID(resultSet.getLong("busi"));
            route.setDriverID(resultSet.getLong("driveri"));

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

        return route;
    }

    @Override
    public void add(Route route) {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO route (" +
                "route_id, " +
                "start_of_route, " +
                "end_of_route, " +
                "departure_date, " +
                "price, " +
                "driveri, " +
                "busi) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, route.getId());
            preparedStatement.setString(2, route.getStartOfRoute());
            preparedStatement.setString(3, route.getEndOfRoute());
            preparedStatement.setDate(4, route.getDepartureDate());
            preparedStatement.setDouble(5, route.getPrice());
            preparedStatement.setLong(6, route.getBusID());
            preparedStatement.setLong(7, route.getDriverID());

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

    }

    @Override
    public List<Route> getAll() {

        List<Route> routes = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM route";

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Route route = new Route();
                route.setId(resultSet.getLong("route_id"));
                route.setStartOfRoute(resultSet.getString("start_of_route"));
                route.setEndOfRoute(resultSet.getString("end_of_route"));
                route.setDepartureDate(resultSet.getDate("departure_date"));
                route.setPrice(resultSet.getFloat("price"));
                route.setBusID(resultSet.getLong("busi"));
                route.setDriverID(resultSet.getLong("driveri"));

                routes.add(route);
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

        return routes;
    }

    @Override
    public void update(Route route) {

        PreparedStatement preparedStatement = null;
//        String sql = "UPDATE route SET start_of_route=?, " +
//                "end_of_route=?, " +
//                "departure_date=?, " +
//                "price=?, " +
//                "driveri=?, " +
//                "busi=? " +
//                "WHERE route_id=?";
        String sql = "UPDATE route SET driveri=?, busi=? WHERE route_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setString(1, route.getStartOfRoute());
//            preparedStatement.setString(2, route.getEndOfRoute());
//            preparedStatement.setDate(3, route.getDepartureDate());
//            preparedStatement.setFloat(4, route.getPrice());
            preparedStatement.setLong(1, route.getDriverID());
            preparedStatement.setLong(2, route.getBusID());
            preparedStatement.setLong(3, route.getId());

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
    public void remove(Route route) {

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM route WHERE route_id=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, route.getId());

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
