package com.codecool.web.service.simple;

import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.model.*;
import com.codecool.web.service.Task1Service;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask1Service implements Task1Service {

    private final NorthwindDao northwindDao;

    public SimpleTask1Service(NorthwindDao northwindDao) {
        this.northwindDao = northwindDao;
    }

    @Override
    public List<Task1> getTask1() throws SQLException {
        return northwindDao.task1();
    }

    @Override
    public List<Task2> getTask2() throws SQLException {
        return northwindDao.task2();
    }

    @Override
    public List<Task3> getTask3() throws SQLException {
        return northwindDao.task3();
    }

    @Override
    public List<Task4> getTask4() throws SQLException {
        return northwindDao.task4();
    }

    @Override
    public List<Task5> getTask5() throws SQLException {
        return northwindDao.task5();
    }

    @Override
    public List<Task1> getFilteredTask1(String companyName) throws SQLException {
        return northwindDao.findTask1(companyName);
    }

    @Override
    public List<Task2> getFilteredTask2(String companyName) throws SQLException {
        return northwindDao.findTask2(companyName);
    }

    @Override
    public List<Task3> getFilteredTask3(String companyName) throws SQLException {
        return northwindDao.findTask3(companyName);
    }

    @Override
    public List<Task4> getFilteredTask4(String companyName) throws SQLException {
        return northwindDao.findTask4(companyName);
    }

    @Override
    public List<Task5> getFilteredTask5(String companyName) throws SQLException {
        return northwindDao.findTask5(companyName);
    }

}
