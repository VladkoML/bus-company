package dao;

import entity.Route;

import java.util.List;

public interface RouteDAO {

    //get one
    Route getById(Long id);

    //get one
    Route getByDriverAndBusId(Long busID, Long driverID);

    //create
    void add(Route route);

    //read
    List<Route> getAll();

    //update
    void update(Route route);

    //delete
    void remove(Route route);

}
