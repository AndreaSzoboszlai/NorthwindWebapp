package com.codecool.web.service;

import com.codecool.web.model.*;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Task1Service {

    List<Task1> getTask1() throws SQLException;

    List<Task2> getTask2() throws SQLException;

    List<Task3> getTask3() throws SQLException;

    List<Task4> getTask4() throws SQLException;

    List<Task5> getTask5() throws SQLException;

    List<Task1> getFilteredTask1(String companyName) throws SQLException;

    List<Task2> getFilteredTask2(String companyName) throws SQLException;

    List<Task3> getFilteredTask3(String companyName) throws SQLException;

    List<Task4> getFilteredTask4(String companyName) throws SQLException;

    List<Task5> getFilteredTask5(String companyName) throws SQLException;
}
