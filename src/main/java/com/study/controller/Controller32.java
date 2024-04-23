package com.study.controller;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.mapper.Mapper03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {
    private final Mapper03 mapper;

    @RequestMapping("sub1")
    public void method1() {
        int rowCount = mapper.deleteOneCustomer();
        System.out.println(rowCount + "명의 고객이 삭제되었습니다.");
    }

    @RequestMapping("sub2")
    public void method2(Integer cid) {
        int rowCount = mapper.deleteOneCustomerById(cid);
        System.out.println(cid + "번 고객, 총 " + rowCount + "명이 삭제되었습니다.");
    }

    @RequestMapping("sub3")
    public void method3(Integer eid) {
        int rowCount = mapper.deleteOneEmployeeById(eid);
        System.out.println(eid + "번 직원, 총 " + rowCount + "명이 삭제되었습니다.");
    }

    @GetMapping("sub4")
    public void method4(MyBean25C customer) {
        mapper.insertCustomer(customer);
    }

    @GetMapping("sub5")
    public void method5(MyBean25E employee) {
        mapper.insertEmployee(employee);
    }
}
