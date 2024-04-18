package com.study.controller;

import com.study.domain.MyBean26O;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(String start, String end, Model model) throws SQLException {
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
}
