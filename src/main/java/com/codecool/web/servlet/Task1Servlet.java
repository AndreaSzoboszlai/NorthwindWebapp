package com.codecool.web.servlet;


import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.dao.database.DatabaseNorthwindDao;
import com.codecool.web.model.Task1;
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


@WebServlet("/Task1")
public class Task1Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            NorthwindDao northwindDaoDao = new DatabaseNorthwindDao(connection);
            Task1Service taskService = new SimpleTask1Service(northwindDaoDao);

            List<Task1> task1 = taskService.getTask1();
            req.setAttribute("task1", task1);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }
}
