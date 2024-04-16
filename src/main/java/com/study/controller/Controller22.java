package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @GetMapping("sub1")
    public String sub1() {
        // view forward
        return "/main22/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        // 'redirect:'를 붙이면
        // redirection 응답 (302)
        // 브라우저는 302 응답을 받으면
        // Location 헤더에 있는 값으로 다시 요청을 보냄

        return "redirect:/main22/sub1";
    }

    @GetMapping("sub3")
    public void method3() {
    }

    @PostMapping("sub4")
    public String sub4(String id, String password) {
        boolean ok = id.equals(password);
        if (ok) {
            // 로그인 성공 시
            // 성공 후 보여주는 페이지로 이동
            return "redirect:/main22/sub5";
        } else {
            // 로그인 실패 시
            // 로그인 form 있는 페이지로 이동
            return "redirect:/main22/sub3";
        }
    }

    @GetMapping("sub5")
    public void method5() {
    }

    @GetMapping("sub6")
    public void method6() {
        // login form 있는 view로 포워드
    }

    @PostMapping("sub7")
    public String sub7(String id, String password) {
        boolean ok = id.equals(password);
        if (ok) {
            return "redirect:/main22/sub8";
        } else {
            return "redirect:/main22/sub6";
        }
    }

    @GetMapping("sub8")
    public void method8() {
    }
}