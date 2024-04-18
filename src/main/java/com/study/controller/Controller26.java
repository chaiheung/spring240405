package com.study.controller;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25P;
import com.study.domain.MyBean26Ca;
import com.study.domain.MyBean26O;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String method1(String start, String end, Model model) throws SQLException {
        var list = new ArrayList<MyBean26O>();
        String sql = """
                SELECT *
                FROM Orders
                WHERE OrderDate BETWEEN ? AND ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, start);
        pstmt.setString(2, end);
        ResultSet rs = pstmt.executeQuery();

        try (rs; conn; pstmt) {
            while (rs.next()) {
                MyBean26O row = new MyBean26O();
                row.setId(rs.getInt(1));
                row.setCustomerId(rs.getInt(2));
                row.setEmployeeId(rs.getInt(3));
                row.setDate(rs.getString(4));
                row.setShipperId(rs.getInt(5));
                list.add(row);
            }
        }
        model.addAttribute("prevStart", start);
        model.addAttribute("prevEnd", end);
        model.addAttribute("orderList", list);
        return "main26/subO";
    }

    @GetMapping("sub2")
    public String method2(String[] country, Model model) throws Exception {
        Connection conn = dataSource.getConnection();

        if (country != null && country.length > 0) {
            String questionMarks = "";
            for (int i = 0; i < country.length; i++) {
                questionMarks = questionMarks + "?";
                if (i != country.length - 1) {
                    questionMarks = questionMarks + ",";
                }
            }
            String customerSql = STR."""
                SELECT *
                FROM Customers
                WHERE Country IN (\{questionMarks})
                """;


            var list = new ArrayList<MyBean25C>();
            PreparedStatement pstmt = conn.prepareStatement(customerSql);
            for (int i = 0; i < country.length; i++) {
                pstmt.setString((i + 1), country[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            try (rs; pstmt) {
                while (rs.next()) {
                    MyBean25C data = new MyBean25C();
                    data.setId(rs.getInt(1));
                    data.setName(rs.getString(2));
                    data.setContactName(rs.getString(3));
                    data.setAddress(rs.getString(4));
                    data.setCity(rs.getString(5));
                    data.setPostalCode(rs.getString(6));
                    data.setCountry(rs.getString(7));
                    list.add(data);
                }
                model.addAttribute("customerList", list);
            }
        }

        String sql = """
                SELECT DISTINCT Country
                FROM Customers
                """;

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        var countryList = new ArrayList<String>();
        try (stmt; rs;) {
            while (rs.next()) {
                countryList.add(rs.getString(1));
            }
            model.addAttribute("countryList", countryList);
        }

        return "main25/subC";
    }

    @GetMapping("sub3")
    public String method3(@RequestParam(value = "category", required = false)
                          String[] cat, Model model) throws Exception {
        Connection conn = dataSource.getConnection();
        if (cat != null && cat.length > 0) {
            String qm = "";
            for (int i = 0; i < cat.length; i++) {
                qm += "?";
                if (i != cat.length - 1) {
                    qm += ",";
                }
            }
            String productSql = STR."""
                    SELECT *
                    FROM Products
                    WHERE CategoryID IN (\{qm})
                    ORDER BY CategoryID, Price
                    """;
            PreparedStatement pstmt = conn.prepareStatement(productSql);
            for (int i = 0; i < cat.length; i++) {
                pstmt.setString((i + 1), cat[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            var list = new ArrayList<MyBean25P>();
            try (rs; pstmt;) {
                while (rs.next()) {
                    MyBean25P data = new MyBean25P();
                    data.setId(rs.getInt(1));
                    data.setName(rs.getString(2));
                    data.setSid(rs.getInt(3));
                    data.setCid(rs.getInt(4));
                    data.setUnit(rs.getString(5));
                    data.setPrice(rs.getDouble(6));
                    list.add(data);
                }
                model.addAttribute("prevCategorySelect", cat);
                model.addAttribute("productList", list);
            }
        }
        String categorySql = "SELECT * FROM Categories";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(categorySql);
        var categoryList = new ArrayList<MyBean26Ca>();
        try (rs; stmt;) {
            while (rs.next()) {
                MyBean26Ca category = new MyBean26Ca();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                categoryList.add(category);
            }
            model.addAttribute("categoryList", categoryList);
        }

        return "main25/subP";
    }
}
