package com.study.controller;

import com.study.domain.MyBean13A;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @RequestMapping("sub1")
    public void sub1(Model model) {
        MyBean13A obj1 = new MyBean13A("신촌", "서울", 44);
        model.addAttribute("obj1", obj1);
    }

    @RequestMapping("sub2")
    public void sub2(Model model) {
    }
}