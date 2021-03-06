package com.codecool.web.dao.database;

import com.codecool.web.dao.NorthwindDao;
import com.codecool.web.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseNorthwindDao extends AbstractDao implements NorthwindDao {

    public DatabaseNorthwindDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1> task1() throws SQLException {
        List<Task1> task1QueryResult = new ArrayList<>();
        String sql = "SELECT product_name AS product, company_name AS company FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id ORDER BY product ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task1QueryResult.add(fetchTask1(resultSet));
            }
        }
        return task1QueryResult;
    }

    //SELECT product_name AS product, company_name AS company FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id WHERE company_name=? ORDER BY product ASC;

    @Override
    public List<Task2> task2() throws SQLException {
        List<Task2> task2QueryResult = new ArrayList<>();
        String sql = "SELECT company_name AS company, COUNT(product_name) as products from products JOIN suppliers on products.supplier_id = suppliers.supplier_id GROUP BY suppliers.company_name ORDER BY Products DESC, Company ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task2QueryResult.add(fetchTask2(resultSet));
            }
        }
        return task2QueryResult;
    }

    @Override
    public List<Task3> task3() throws SQLException {
        List<Task3> task3QueryResult = new ArrayList<>();
        String sql = "SELECT company_name AS company FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id GROUP BY company_name HAVING COUNT(product_name) >= 5\n" +
            "ORDER BY company ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task3QueryResult.add(fetchTask3(resultSet));
            }
        }
        return task3QueryResult;
    }

    public List<Task4> task4() throws SQLException {
        List<Task4> task4QueryResult = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id\n" +
            "FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id\n" +
            "GROUP BY customers.company_name\n" +
            "ORDER BY company ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task4QueryResult.add(fetchTask4(resultSet));
            }
        }
        return task4QueryResult;
    }

    public List<Task5> task5() throws SQLException {
        List<Task5> task5QueryResult = new ArrayList<>();
        String sql = "select suppliers.company_name, products.product_name, products.unit_price from products " +
            " inner join suppliers on suppliers.supplier_id = products.supplier_id join (select products.supplier_id, MAX(products.unit_price) as max_unit " +
            " from products group by products.supplier_id) as try on products.supplier_id = try.supplier_id and products.unit_price = try.max_unit order by unit_price desc";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task5QueryResult.add(fetchTask5(resultSet));
            }
        }
        return task5QueryResult;
    }

    @Override
    public List<Task1> findTask1(String companyName) throws SQLException {
        List<Task1> foundTask1 = new ArrayList<>();
        String sql = "SELECT product_name AS product, company_name AS company FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id WHERE company_name=? ORDER BY product ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    foundTask1.add(fetchTask1(resultSet));
                }
            }
        }
        return foundTask1;
    }

    @Override
    public List<Task2> findTask2(String companyName) throws SQLException {
        List<Task2> foundTask2 = new ArrayList<>();
        String sql = "SELECT company_name AS company, COUNT(product_name) as products from products JOIN suppliers on products.supplier_id = suppliers.supplier_id WHERE company_name=? GROUP BY suppliers.company_name ORDER BY Products DESC, Company ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    foundTask2.add(fetchTask2(resultSet));
                }
            }
        }
        return foundTask2;
    }

    @Override
    public List<Task3> findTask3(String companyName) throws SQLException {
        List<Task3> foundTask3 = new ArrayList<>();
        String sql = "SELECT company_name AS company FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id WHERE company_name=? GROUP BY company_name HAVING COUNT(product_name) >= 5\n" +
            " ORDER BY company ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    foundTask3.add(fetchTask3(resultSet));
                }
            }
        }
        return foundTask3;
    }

    @Override
    public List<Task4> findTask4(String companyName) throws SQLException {
        List<Task4> foundTask4 = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id\n" +
            "FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id\n" +
            "WHERE company_name=? GROUP BY customers.company_name\n" +
            "ORDER BY company ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    foundTask4.add(fetchTask4(resultSet));
                }
            }
        }
        return foundTask4;
    }

    @Override
    public List<Task5> findTask5(String companyName) throws SQLException {
        List<Task5> foundTask5 = new ArrayList<>();
        String sql = "select suppliers.company_name, products.product_name, products.unit_price from products inner join suppliers on suppliers.supplier_id = products.supplier_id join (select products.supplier_id, MAX(products.unit_price) as max_unit from products group by products.supplier_id) as try on products.supplier_id = try.supplier_id and products.unit_price = try.max_unit where company_name=? order by unit_price desc";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    foundTask5.add(fetchTask5(resultSet));
                }
            }
        }
        return foundTask5;
    }

    private Task1 fetchTask1(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        String company = resultSet.getString("company");
        return new Task1(product, company);
    }

    private Task2 fetchTask2(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        int productNum = resultSet.getInt("products");
        return new Task2(company, productNum);
    }

    private Task3 fetchTask3(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new Task3(company);
    }

    private Task4 fetchTask4(ResultSet resultSet) throws SQLException {
        List<Integer> orderIDList = new ArrayList<>();
        String company = resultSet.getString("company");
        Array orderIds = resultSet.getArray("order_id");
        Short[] orderIdArray = (Short[])orderIds.getArray();
        for (Short id : orderIdArray){
            if (id == null) {
                id = 0;
            }
            int num = Integer.valueOf(id);
            orderIDList.add(num);
        }
        return new Task4(company, orderIDList);
    }

    private Task5 fetchTask5(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company_name");
        String product = resultSet.getString("product_name");
        Double price = resultSet.getDouble("unit_price");
        return new Task5(company, product, price);
    }
}
