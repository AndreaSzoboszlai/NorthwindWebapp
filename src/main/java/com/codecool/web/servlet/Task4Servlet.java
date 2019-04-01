package com.codecool.web.servlet;


import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.dao.database.DatabaseNorthwindDao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
import com.codecool.web.model.Task3;
import com.codecool.web.model.Task4;
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


@WebServlet("/Task4")
public class Task4Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);

            List<Task4> task4 = taskService.getTask4();
            req.setAttribute("task4", task4);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task4.jsp").forward(req, resp);
    }
}
