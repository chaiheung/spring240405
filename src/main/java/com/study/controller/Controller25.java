package com.study.controller;

import com.study.domain.MyBean25A;
import com.study.domain.MyBean25B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(@RequestParam(value = "name", required = false) String searchName, Model model) throws SQLException {
        ArrayList<MyBean25A> list = new ArrayList<>();
        // jdk 21
        String sql = STR."""
                SELECT *
                FROM Employees
                WHERE LastName = '\{searchName}'
                """;
//        // jdk 21 이전
//        String sql = """
//                SELECT *
//                FROM Employees
//                WHERE LastName = '""" + searchName + "'";

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try (rs; stmt; conn) {
            while (rs.next()) {
                String id = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String birthDate = rs.getString(4);
                String photo = rs.getString(5);
                String notes = rs.getString(6);

                MyBean25A obj = new MyBean25A(id, lastName, firstName,
                        birthDate, photo, notes);
                list.add(obj);
            }
            model.addAttribute("employees", list);
        }
    }

    @GetMapping("sub2")
    public void method2(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        String sql = STR."""
                SELECT *
                FROM Products
                WHERE ProductName = '\{search}'
                """;
        var list = new ArrayList<MyBean25B>();
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String unit = rs.getString(5);
            double price = rs.getDouble(6);

            MyBean25B product = new MyBean25B(id, name, unit, price);
            list.add(product);
        }
        model.addAttribute("products", list);
    }
}
