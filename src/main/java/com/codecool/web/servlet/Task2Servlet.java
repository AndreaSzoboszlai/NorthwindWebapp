package com.codecool.web.servlet;


import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.dao.database.DatabaseNorthwindDao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.simple.SimpleTask1Service;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/Task2")
public class Task2Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);

            List<Task2> task2 = taskService.getTask2();
            req.setAttribute("task2", task2);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);
            String companyName = req.getParameter("filter2");
            List<Task2> task2 = taskService.getFilteredTask2(companyName);
            req.setAttribute("task2", task2);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task2.jsp").forward(req, resp);
    }
}
