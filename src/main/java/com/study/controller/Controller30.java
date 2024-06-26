package com.study.controller;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.mapper.Mapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("main30")
public class Controller30 {
    @Autowired
    private DataSource dataSource;

    // 직접 만든 객체(dependency)
    // private Mapper01 mapper = new Mapper01();
    // Inversion of Control (IoC)
    @Autowired
    private Mapper01 mapper;

    @GetMapping("sub1")
    public void method1(Integer id, Model model) throws Exception {
        MyBean25C c = mapper.getCustomerById(id);
        model.addAttribute("customer", c);
    }

    @PostMapping("sub1/update")
    public String update1(MyBean25C customer, RedirectAttributes rttr) throws SQLException {
        System.out.println(customer);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerID = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (conn; pstmt;) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getPostalCode());
            pstmt.setString(6, customer.getCountry());
            pstmt.setInt(7, customer.getId());
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", customer.getId() + "번 고객이 수정되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "수정되지 않았습니다.");
            }
        }
        rttr.addAttribute("id", customer.getId());
        return "redirect:/main30/sub1";
    }

    @GetMapping("sub2")
    public void method2(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT * FROM Employees
                    WHERE EmployeeId = ?
                    """;
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            try (conn; pstmt;) {
                if (rs.next()) {
                    MyBean25E e = new MyBean25E();
                    e.setId(rs.getInt(1));
                    e.setLastName(rs.getString(2));
                    e.setFirstName(rs.getString(3));
                    e.setBirthDate(rs.getString(4));
                    e.setPhoto(rs.getString(5));
                    e.setNotes(rs.getString(6));
                    model.addAttribute("employee", e);
                }
            }
        }
    }

    @PostMapping("sub2/update")
    public String update2(MyBean25E employee, RedirectAttributes rttr) throws SQLException {
        System.out.println(employee);
        String sql = """
                UPDATE Employees
                SET LastName = ?,
                FirstName = ?,
                BirthDate = ?,
                Photo = ?,
                Notes = ?
                WHERE EmployeeId = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (conn; pstmt;) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getBirthDate());
            pstmt.setString(4, employee.getPhoto());
            pstmt.setString(5, employee.getNotes());
            pstmt.setInt(6, employee.getId());
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", employee.getId() + "번 직원 정보가 수정되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "수정이 완료되지 않았습니다.");
            }
        }
        rttr.addAttribute("id", employee.getId());
        return "redirect:/main30/sub2";
    }
}
