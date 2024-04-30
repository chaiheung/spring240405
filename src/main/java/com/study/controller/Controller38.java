package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller38 {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/path1")
    // 로그인 후 사용
    // https://docs.spring.io/spring-security/reference/5.8/servlet/authorization/expression-based.html
    @PreAuthorize("isAuthenticated()")
    public void path1() {
        System.out.println("Controller38.path1");
    }

    @GetMapping("/path2")
    @PreAuthorize("hasAuthority('user')")
    public void path2() {
        System.out.println("사용자 권한으로 실행 가능");
    }

    @GetMapping("/path3")
    @PreAuthorize("hasAuthority('admin')")
    public void path3() {
        System.out.println("관리자 권한으로 실행 가능");
    }

    @GetMapping("/path4")
    public void path4() {
    }
}
