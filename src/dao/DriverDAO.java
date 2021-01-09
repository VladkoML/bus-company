package dao;

import entity.Driver;

import java.util.List;

public interface DriverDAO {

    //get one
    Driver getById(Long id);

    //create
    void add(Driver driver);

    //read
    List<Driver> getAll();

    //update
    void update(Driver driver);

    //delete
    void remove(Driver driver);

}
