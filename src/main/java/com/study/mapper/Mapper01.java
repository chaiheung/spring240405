package com.study.mapper;

import com.study.domain.MyBean25C;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class Mapper01 {
    public MyBean25C getCustomerById(Integer id) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT * FROM Customers
                    WHERE CustomerId = ?
                    """;
            Connection conn = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/w3schools", "root", "1234");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            try (conn; pstmt; rs;) {
                if (rs.next()) {
                    MyBean25C c = new MyBean25C();
                    c.setId(rs.getInt(1));
                    c.setName(rs.getString(2));
                    c.setContactName(rs.getString(3));
                    c.setAddress(rs.getString(4));
                    c.setCity(rs.getString(5));
                    c.setPostalCode(rs.getString(6));
                    c.setCountry(rs.getString(7));

                    return c;
                }
            }
        }
        return null;
    }
}
