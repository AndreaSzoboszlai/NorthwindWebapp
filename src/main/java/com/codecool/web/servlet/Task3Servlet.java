package com.codecool.web.servlet;


import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.dao.database.DatabaseNorthwindDao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
import com.codecool.web.model.Task3;
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


@WebServlet("/Task3")
public class Task3Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);

            List<Task3> task3 = taskService.getTask3();
            req.setAttribute("task3", task3);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);
            String companyName = req.getParameter("filter3");
            List<Task3> task3 = taskService.getFilteredTask3(companyName);
            req.setAttribute("task3", task3);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }
}
