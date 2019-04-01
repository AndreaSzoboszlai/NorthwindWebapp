package com.codecool.web.servlet;


import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.dao.database.DatabaseNorthwindDao;
import com.codecool.web.model.Task5;
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


@WebServlet("/Task5")
public class Task5Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDao);

            List<Task5> task5 = taskService.getTask5();
            req.setAttribute("task5", task5);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task5.jsp").forward(req, resp);
    }
}
