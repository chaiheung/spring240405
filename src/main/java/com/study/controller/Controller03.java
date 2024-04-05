package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main3")
public class Controller03 {
    // 경로 : /main3/sub1
    @RequestMapping("sub1")
    public void method1() {
        System.out.println("Controller03.method1");
    }

    // 경로 : /main3/sub2
    @RequestMapping("sub2")
    public void method2() {
        System.out.println("Controller03.method2");
    }

    // 경로 : /main3/sub3
    // 파라미터 : name
    // /main3/sub3?name
    @RequestMapping(value = "sub3", params = "name")
    public void method3() {
        System.out.println("Controller03.method3");
    }

    // /main3/sub3?name&age
    @RequestMapping(value = "sub3", params = {"name", "age"})
    public void method4() {
        System.out.println("Controller03.method4");
    }

    // /main3/sub3?address&city
    @RequestMapping(value = "sub3", params = {"address", "city"})
    public void method5() {
        System.out.println("Controller03.method5");
    }

    // /main3/sub3?country&city
    // /main3/sub3?city&country
    // /main3/sub3?country=korea&city=seoul
    @RequestMapping(value = "sub3", params = {"country", "city"})
    public void method6() {
        System.out.println("Controller03.method6");
    }
}