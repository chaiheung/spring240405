package com.study.mapper;

import com.study.domain.MyBean25E;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper08 {
    @Select("""
             <script>
             SELECT * 
             FROM Employees
             WHERE LastName = 'abc'
                <if test="false">
                OR FirstName = 'abc'
                </if>
            </script>
             """)
    List<MyBean25E> query1();

    @Select("""
            <script>
                SELECT * FROM my_table
                <if test="lastName != null">
                -- lastName이 null이 아닐 때 포함되는 어떤 코드
                </if>
                <if test="lastName == null">
                -- lastName이 null일 때 포함되는 어떤 코드
                </if>
            </script>
            """)
    Object query2(MyBean25E e);

    @Select("""
            <script>
                SELECT * FROM my_table
                <if test="firstName == 'lee'">
                         -- firstName 이 lee 일 때 포함되는 코드
                </if>
                <if test="firstName != 'lee'">
                        -- firstName 이 lee가 아닐 때 포함되는 코드
                </if>
            </script>
            """)
    Object query3(MyBean25E e);

    @Select("""
            <script>
            SELECT * FROM my_table
            <if test="firstName eq null">
            -- firstName 이 null 일 때 포함되는 코드
            </if>
            <if test="firstName neq null">
            -- firstName 이 null 아닐 때 포함되는 코드
            </if>
            <if test='firstName == "kim"'>
            -- firstName 이 "kim" 일 때 포함되는 코드
            </if>
            <if test='firstName eq "lee"'>
            -- firstName 이 "lee" 일 때 포함되는 코드
            </if>
            </script>
            """)
    Object query4(MyBean25E e);

    @Select("""
            <script>
            SELECT * FROM my_table
                <trim prefix="WHERE" prefixOverrides="OR">
                    <if test="lastName != null">
                    OR    LastName = #{lastName}
                    </if>
                    <if test="firstName != null">
                    OR    firstName = #{firstName}
                    </if>
                </trim>
            </script>
            """)
    Object query5(MyBean25E e);
}