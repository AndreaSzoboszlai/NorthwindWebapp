package com.codecool.web.dao;

import com.codecool.web.model.*;

import java.sql.SQLException;
import java.util.List;

public interface NorthwindDao {

    List<Task1> task1() throws SQLException;

    List<Task2> task2() throws SQLException;

    List<Task3> task3() throws SQLException;

    List<Task4> task4() throws SQLException;

    List<Task5> task5() throws SQLException;

}
