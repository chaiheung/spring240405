package com.study.mapper;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface Mapper07 {

    @Insert("""
            INSERT INTO Employees
            (LastName, FirstName)
            VALUES(#{lastName},#{firstNName})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(MyBean25E e);

    @Insert("""
            INSERT INTO Customers
            (CustomerName, Country)
            VALUES(#{name},#{country})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(MyBean25C c);
}
