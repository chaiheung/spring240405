package com.study.mapper;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.domain.MyBean25P;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper02 {
    @Select("SELECT NOW()")
    public String selectNow();

    // 조회 결과의 컬럼명과
    // 리턴타입의 객체 프로퍼티명이 같으면
    // 값을 바인딩 해줌
    @Select("""
            SELECT ContactName, Address, City, Country
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean25C selectOneCustomer();

    @Select("""
            SELECT *
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean25C selectOneCustomer2();

    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   ContactName,
                   Address,
                   City,
                   Country,
                   PostalCode
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean25C selectOneCustomer3();

    @Select("""
            SELECT EmployeeId id, FirstName, LastName, BirthDate, Photo, Notes
            FROM Employees
            WHERE EmployeeID = 2
            """)
    MyBean25E selectOneEmployee1();

    @Select("""
            SELECT EmployeeID id,
                   LastName,
                   FirstName,
                   Photo,
                   Notes,
                   BirthDate
            FROM Employees
            WHERE EmployeeID = #{id}
            """)
    MyBean25E selectOneEmployee2(Integer id);

    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   ContactName,
                   Address,
                   City,
                   Country,
                   PostalCode
            FROM Customers
            WHERE CustomerID = #{id}
            """)
    MyBean25C selectOneCustomer4(Integer id);


    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   ContactName,
                   Address,
                   City,
                   Country,
                   PostalCode
            FROM Customers
            """)
    List<MyBean25C> selectAllCustomers1();

    @Select("""
            SELECT EmployeeID id,
                   LastName,
                   FirstName,
                   Photo,
                   Notes,
                   BirthDate
            FROM Employees
            ORDER BY BirthDate DESC
            """)
    List<MyBean25E> selectAllEmployees1();


    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   ContactName,
                   Address,
                   City,
                   Country,
                   PostalCode
            FROM Customers
            WHERE Country = #{country1} 
               OR Country = #{country2}
            ORDER BY Country
            """)
    List<MyBean25C> selectCustomersByCountry(String country1, String country2);

    @Select("""
            SELECT ProductId id, ProductName name, SupplierId sid, CategoryId cid, Unit, Price
            FROM Products
            WHERE Price BETWEEN #{min} AND #{max}
            ORDER BY Price
            """)
    List<MyBean25P> selectProductsByPriceBetween(double min, double max);
}
