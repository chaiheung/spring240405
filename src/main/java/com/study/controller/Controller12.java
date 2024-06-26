package com.study.controller;

import com.study.domain.MyBean12A;
import com.study.domain.MyBean12B;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main12")
public class Controller12 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("age", 15);
        model.addAttribute("products", List.of());
//        model.addAttribute("products", List.of("Apple", "Banana"));

//        model.addAttribute("member",
//                Map.of("country", "korea",
//                        "age", 30));

//        model.addAttribute("member",
//                Map.of("country", "korea",
//                        "age", 15));
//
//        model.addAttribute("member",
//                Map.of("country", "us",
//                        "age", 30));
//
        model.addAttribute("member",
                Map.of("country", "us",
                        "age", 15));
        // /main12/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
//        model.addAttribute("age", 3); // 어린이용 콘텐츠
//        model.addAttribute("age", 13); // 청소년용 콘텐츠
//        model.addAttribute("age", 23); // 성인용 콘텐츠
        model.addAttribute("age", 33); // 성인용 콘텐츠
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        model.addAttribute("dan", 2);
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        model.addAttribute("myList",
                List.of("java", "css", "react"));
        model.addAttribute("foods",
                List.of("pizza", "burger", "찌개", "돈까스"));
        model.addAttribute("myMap",
                Map.of("son", "london",
                        "lee", "paris",
                        "kim", "munich"));
        model.addAttribute("cars",
                Map.of("tesla", "usa",
                        "kia", "korea",
                        "volvo", "sweden"));
        model.addAttribute("myList2",
                List.of("alpha", "beta", "gamma"));
        model.addAttribute("myMap2",
                Map.of("seoul", "korea",
                        "beijing", "china",
                        "tokyo", "japan"));
    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("myList", List.of("java", "css", "react"));
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        MyBean12A e1 = new MyBean12A("모하비", "kia", "한국", 3000);
        MyBean12A e2 = new MyBean12A("모델x", "tesla", "미국", 4000);
        MyBean12A e3 = new MyBean12A("XC90", "volvo", "스웨덴", 5000);
        MyBean12A e4 = new MyBean12A("X5", "bmw", "독일", 7000);

        model.addAttribute("cars", List.of(e1, e2, e3, e4));
    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        MyBean12B e1 = new MyBean12B("son", "tot", "korea", "football", List.of("ST"));
        MyBean12B e2 = new MyBean12B("otani", "la", "japan", "baseball", List.of("P"));
        MyBean12B e3 = new MyBean12B("curry", "gsw", "usa", "basketball", List.of("PG"));
        MyBean12B e4 = new MyBean12B("lee", "psg", "korea", "football", List.of("CAM"));
        MyBean12B e5 = new MyBean12B("kim", "fcb", "korea", "football", List.of("CB"));
        model.addAttribute("playerList", List.of(e1, e2, e3, e4, e5));
    }
}