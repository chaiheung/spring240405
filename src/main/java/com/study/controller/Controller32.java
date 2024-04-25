package com.study.controller;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.mapper.Mapper02;
import com.study.mapper.Mapper03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {
    private final Mapper03 mapper;
    private final Mapper02 mapper02;

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
        // form이 있는 view forwarding
        // mapper.insertEmployee(employee);
    }

    @PostMapping("sub5")
    public String method6(MyBean25E employee, RedirectAttributes rttr) {
        int rows = mapper.insertEmployee(employee);
        if (rows > 0) {
            rttr.addFlashAttribute("message", rows + "명의 직원이 입력되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "입력이 되지 않았습니다.");
        }
        return "redirect:/main32/sub5";
    }

    @GetMapping("sub6")
    public void method7(@RequestParam(value = "id", required = false) Integer eid,
                        Model model) {
        if (eid != null) {
            MyBean25E e = mapper02.selectOneEmployee2(eid);
            model.addAttribute("employee", e);
        }
    }

    @PostMapping("sub6/update")
    public String method8(MyBean25E employee, RedirectAttributes rttr) {
        int i = mapper.updateEmployee(employee);

        if (i > 0) {
            rttr.addFlashAttribute("message", i + "명 직원이 수정되었습니다");
        } else {
            rttr.addFlashAttribute("message", "입력되지 않았습니다.");
        }

        rttr.addAttribute("id", employee.getId());
        return "redirect:/main32/sub6";
    }

    @GetMapping("sub7")
    public void method8(Integer id, Model model) {
        if (id != null) {
            MyBean25C c = mapper02.selectOneCustomer4(id);
            model.addAttribute("customer", c);
        }
    }

    @PostMapping("sub7/update")
    public String method9(MyBean25C customer, RedirectAttributes rttr) {
        mapper.updateCustomer(customer);

        rttr.addAttribute("id", customer.getId());
        return "redirect:/main32/sub7";
    }
}
