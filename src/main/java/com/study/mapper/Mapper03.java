package com.study.mapper;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Mapper03 {
    @Delete("""
            DELETE FROM Customers
            WHERE CustomerId = 1
            """)
    int deleteOneCustomer();

    @Delete("""
            DELETE FROM Customers
            WHERE CustomerId = #{id}
            """)
    int deleteOneCustomerById(int id);


    @Delete("""
            DELETE FROM Employees
            WHERE EmployeeId = #{e}
            """)
    int deleteOneEmployeeById(Integer e);


    @Insert(""" 
            INSERT INTO Customers
            (CustomerName, ContactName, Address, City, PostalCode, Country)
            VALUES (#{name}, #{contactName}, #{address}, #{city}, #{poistalCode}, #{country})
            """)
    int insertCustomer(MyBean25C customer);

    @Insert("""
            INSERT INTO Employees
            (LastName, FirstName, BirthDate, Photo, Notes)
            VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes})
            """)
    int insertEmployee(MyBean25E employee);

    @Update("""
            UPDATE Employees
            SET
                LastName = #{lastName},
                FirstName = #{firstName},
                Photo = #{photo},
                Notes = #{notes},
                BirthDate = #{birthDate}
            WHERE
                EmployeeId = #{id}
            """)
    int updateEmployee(MyBean25E employee);
}
