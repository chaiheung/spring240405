package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main8")
public class Controller08 {
    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("name1", "value1");
        model.addAttribute("name2", "value2");
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("city", "seoul");
        model.addAttribute("address", "sinchon");
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        model.addAttribute("name", "bori");
        model.addAttribute("age", 10);
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        // model attribute의 name : String
        // model attribute의 value : Object

        // 자주 사용하는 타입
        // String, 기본타입(Wrapper)
        // Arrays, List, Map
        // JavaBeans

        // Arrays
        model.addAttribute("car", new String[]{"tesla", "kia", "hyundai"});

    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("cities", new String[]{"seoul", "daegu", "busan"});
        model.addAttribute("countries", new String[]{"korea", "usa", "kenya"});
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        List<String> data = List.of("java", "css", "html", "jsp");
        model.addAttribute("myList", data);

        // /main8/sub6.jsp
    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        List<String> data = List.of("😂", "😎", "😍");
        model.addAttribute("myList", data);

        List<Integer> numbers = List.of(10, 5, 0);
        model.addAttribute("yourList", numbers);
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        model.addAttribute("numbers", List.of(500.0, 3.14));
        model.addAttribute("cities", List.of("서울", "런던", "뉴욕"));
    }

    @RequestMapping("sub9")
    public void method9(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "흥민");
        map.put("age", "서른");
        map.put("address", "런던");
        model.addAttribute("myMap", map);
    }

    @RequestMapping("sub10")
    public void method10(Model model) {
        Map<String, String> names = Map.of("son", "tot",
                "lee", "psg",
                "kim", "fcb");
        model.addAttribute("names", names);

        Map<String, String> others = Map.of(
                "hm", "london",
                "ki", "paris");
        model.addAttribute("others", others);
    }
}
