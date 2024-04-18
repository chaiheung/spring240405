package com.study.controller;

import com.study.domain.*;
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

    @GetMapping("sub3")
    public void method3(String search, Model model) throws SQLException {
        String oldsql = STR."""
                SELECT * FROM Products
                WHERE ProductName = '\{search}'
                """;
        String sql = """
                SELECT * FROM Products
                WHERE ProductName = ?
                """;

        var list = new ArrayList<MyBean25B>();
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 첫번째 파라미터:물음표 위치
        // 두번째 파라미터:넣을 값
        pstmt.setString(1, search);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            MyBean25B row = new MyBean25B(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(5),
                    rs.getDouble(6));

            list.add(row);
        }
        model.addAttribute("products", list);
    }

    @GetMapping("sub4")
    public String method4(String search, Model model) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE CustomerName = ?";
        var list = new ArrayList<MyBean25C>();

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, search);

        ResultSet rs = pstmt.executeQuery();

        try (rs; conn; pstmt) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String contactName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);
                String country = rs.getString(7);

                MyBean25C obj = new MyBean25C();
                obj.setId(id);
                obj.setName(name);
                obj.setContactName(contactName);
                obj.setAddress(address);
                obj.setCity(city);
                obj.setPostalCode(postalCode);
                obj.setCountry(country);

                list.add(obj);
            }
        }
        model.addAttribute("customerList", list);
        model.addAttribute("prevSearch", search);

        return "main25/subC";
    }

    @GetMapping("sub5")
    public String method5(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean25C>();
        String sql = """
                SELECT * FROM Customers WHERE CustomerName LIKE ?
                """;
        String keyword = "%" + search + "%";

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();
        try (rs; conn; pstmt) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String contactName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);
                String country = rs.getString(7);

                MyBean25C obj = new MyBean25C();
                obj.setId(id);
                obj.setName(name);
                obj.setContactName(contactName);
                obj.setAddress(address);
                obj.setCity(city);
                obj.setPostalCode(postalCode);
                obj.setCountry(country);

                list.add(obj);
            }
        }
        model.addAttribute("customerList", list);
        model.addAttribute("prevSearch", search);

        return "main25/subC";
    }

    @GetMapping("sub6")
    public String method6(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean25P>();
        String sql = """
                SELECT * FROM Products WHERE ProductName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();
        try (rs; conn; pstmt) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int sid = rs.getInt(3);
                int cid = rs.getInt(4);
                String unit = rs.getString(5);
                double price = rs.getDouble(6);

                MyBean25P obj = new MyBean25P();
                obj.setId(id);
                obj.setName(name);
                obj.setSid(sid);
                obj.setCid(cid);
                obj.setUnit(unit);
                obj.setPrice(price);
                list.add(obj);
            }
        }
        model.addAttribute("productList", list);
        model.addAttribute("prevSearch", search);
        return "main25/subP";
    }

    @GetMapping("sub7")
    public String method7(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean25C>();
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        pstmt.setString(2, keyword);
        ResultSet rs = pstmt.executeQuery();

        try (rs; conn; pstmt) {
            while (rs.next()) {
                MyBean25C obj = new MyBean25C();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setContactName(rs.getString(3));
                obj.setAddress(rs.getString(4));
                obj.setCity(rs.getString(5));
                obj.setPostalCode(rs.getString(6));
                obj.setCountry(rs.getString(7));
                list.add(obj);
            }
        }
        model.addAttribute("customerList", list);
        model.addAttribute("prevSearch", search);
        return "main25/subC";
    }

    @GetMapping("sub8")
    public String method8(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean25E>();
        String sql = """
                SELECT *
                FROM Employees
                WHERE LastName LIKE ?
                   OR FirstName LIKE ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + search + "%");
        pstmt.setString(2, "%" + search + "%");
        ResultSet rs = pstmt.executeQuery();

        try (rs; conn; pstmt) {
            while (rs.next()) {
                MyBean25E obj = new MyBean25E();
                obj.setId(rs.getInt(1));
                obj.setLastName(rs.getString(2));
                obj.setFirstName(rs.getString(3));
                obj.setBirthDate(rs.getString(4));
                obj.setPhoto(rs.getString(5));
                obj.setNotes(rs.getString(6));
                list.add(obj);
            }
        }
        model.addAttribute("employeeList", list);
        model.addAttribute("prevSearch", search);
        return "main25/subE";
    }

}
