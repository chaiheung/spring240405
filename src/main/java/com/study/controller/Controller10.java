package com.study.controller;

import com.study.domain.MyBean10A;
import com.study.domain.MyBean10B;
import com.study.domain.MyBean10C;
import com.study.domain.MyBean10D;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {
    @RequestMapping("sub1")
    public void method1(Model model) {
        // 요청 분석
        // 비즈니스 로직 실행
        // 결과를 모델에 담고
        var data = new HashMap<String, List>();
        data.put("key1", List.of("java", "css"));
        data.put("key2", List.of("react", "vue"));
        data.put("key three", List.of("spring", "node"));
        model.addAttribute("myList", data);
        // view로 포워딩 (/WEB-INF/view/main10/sub1.jsp)
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of("son", 7,
                "lee", 19,
                "kim", 30));
        data.add(Map.of("korea", "seoul",
                "japan", "tokyo",
                "usa", "washington dc"));
        model.addAttribute("myAttr", data);
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        var data = new HashMap<String, String>();
        data.put("son", "london");
        data.put("kim", "munich");
        data.put("lee", "paris");
        data.put("jh", "san francisco");
        model.addAttribute("myAttr1", data);
        model.addAttribute("myAttr2", "son");
        model.addAttribute("myAttr3", "kim");
        model.addAttribute("jh", "lee");
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of("son", "london", "lee", "paris"));
        data.add(Map.of("korea", "seoul", "uk", "london"));
        data.add(Map.of("부산", "해운대"));
        data.add(Map.of("서울", "강남"));

        model.addAttribute("list1", data);
        model.addAttribute("number1", 1);
        model.addAttribute("two", 2);
        model.addAttribute("three", "3");
        model.addAttribute("3", 30);
        model.addAttribute("삼", 33);
        model.addAttribute("data1", "son");
        model.addAttribute("data2", "lee");
    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("data", "값 1");
        model.addAttribute("데이타", "값 2");
        model.addAttribute("3", "삼");
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        var data = new ArrayList<MyBean10A>();
        MyBean10A e1 = new MyBean10A();
        MyBean10A e2 = new MyBean10A();
        MyBean10A e3 = new MyBean10A();

        e1.setName("son");
        e1.setAge(32);
        e1.setAddress("london");

        e2.setName("lee");
        e2.setAge(23);
        e2.setAddress("paris");

        e3.setName("kim");
        e3.setAge(28);
        e3.setAddress("munich");

        data.add(e1);
        data.add(e2);
        data.add(e3);

        model.addAttribute("myList", data);
    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        var list = new ArrayList<MyBean10B>();
        MyBean10B e1 = new MyBean10B();
        MyBean10B e2 = new MyBean10B();
        MyBean10B e3 = new MyBean10B();

        e1.setModelName("ferrari");
        e1.setPrice(10_000.00);
        e1.setColor("red");

        e2.setModelName("lamborghini");
        e2.setPrice(9_000.00);
        e2.setColor("yellow");

        e3.setModelName("porsche");
        e3.setPrice(8_000.00);
        e3.setColor("green");

        list.add(e1);
        list.add(e2);
        list.add(e3);

        model.addAttribute("cars", list);
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        var list = new ArrayList<MyBean10C>();

        MyBean10C e1 = new MyBean10C();
        MyBean10C e2 = new MyBean10C();

        // ${myList[0].name}
        e1.setName("한국");
        // ${myList[0].cities[0]}
        // ${myList[0].cities[1]}
        // ${myList[0].cities[2]}
        e1.setCities(List.of("서울", "인천", "부산"));

        // ${myList[1].name}
        e2.setName("미국");
        // ${myList[1].cities[0]}
        // ${myList[1].cities[1]}
        e2.setCities(List.of("뉴욕", "LA"));

        list.add(e1);
        list.add(e2);

        model.addAttribute("myList", list);
    }

    @RequestMapping("sub9")
    public void method9(Model model) {
        var data = new ArrayList<MyBean10D>();
        MyBean10D e1 = new MyBean10D();
        MyBean10D e2 = new MyBean10D();


        e1.setCity("seoul");
        e1.setFoods(List.of("김치", "제육", "삼겹살"));

        e2.setCity("london");
        e2.setFoods(List.of("피쉬", "칩스", "민트초코"));

        var obj = List.of(e1, e2);
        model.addAttribute("data", obj);
    }
}
