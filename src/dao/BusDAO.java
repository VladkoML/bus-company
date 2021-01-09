package dao;

import entity.Bus;

import java.util.List;

public interface BusDAO {

    //get one
    Bus getById(Long id);

    //create
    void add(Bus bus);

    //read
    List<Bus> getAll();

    //update
    void update(Bus bus);

    //delete
    void remove(Bus bus);

}
