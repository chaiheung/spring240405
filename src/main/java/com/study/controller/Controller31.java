package com.study.controller;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.domain.MyBean25P;
import com.study.mapper.Mapper02;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main31")
public class Controller31 {

    private final Mapper02 mapper;

    @GetMapping("sub1")
    public void method1() {
        String now = mapper.selectNow();
        System.out.println("now = " + now);
    }

    @GetMapping("sub2")
    public String method2() {
        MyBean25C customer = mapper.selectOneCustomer();
        System.out.println("customer = " + customer);

        return null;
    }

    @GetMapping("sub3")
    public void method3() {
        MyBean25C c = mapper.selectOneCustomer2();
        System.out.println("c = " + c);
    }

    @GetMapping("sub4")
    public void method4() {
        MyBean25C c = mapper.selectOneCustomer3();
        System.out.println("c = " + c);
    }

    @GetMapping("sub5")
    public void method5() {
        MyBean25E e = mapper.selectOneEmployee1();
        System.out.println("e = " + e);
    }

    @GetMapping("sub6")
    public void method6() {
        MyBean25E e = mapper.selectOneEmployee2(4);
        System.out.println("e = " + e);
    }

    @GetMapping("sub7")
    public void method7(Integer id) {
        MyBean25E e = mapper.selectOneEmployee2(id);
        System.out.println("e = " + e);
    }

    @GetMapping("sub8")
    public void method8(Integer id) {
        MyBean25C c = mapper.selectOneCustomer4(id);
        System.out.println("c = " + c);
    }

    @GetMapping("sub9")
    public void method9(Integer id) {
        List<MyBean25C> customers = mapper.selectAllCustomers1();
        System.out.println("customers = " + customers);
    }

    @GetMapping("sub10")
    public void method10() {
        List<MyBean25E> list = mapper.selectAllEmployees1();
        list.forEach(System.out::println);
    }

    @GetMapping("sub11")
    public void method11() {
        List<MyBean25C> list = mapper.selectCustomersByCountry("usa", "uk");
        list.forEach(System.out::println);
    }

    @GetMapping("sub12")
    public void method12(Double min, Double max) {
        List<MyBean25P> list = mapper.selectProductsByPriceBetween(min, max);
        list.forEach(System.out::println);
    }
}
