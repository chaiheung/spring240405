package com.study.service;

import com.study.domain.MyBean25C;
import com.study.domain.MyBean25E;
import com.study.mapper.Mapper07;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class Service03 {
    private final Mapper07 mapper;

    public void insertData() {
        MyBean25E e = new MyBean25E();
        e.setLastName("박");
        e.setFirstName("지성");
        mapper.insert(e);
        System.out.println(e.getId()); // 생성된 키값
    }

    public void insertData2() {
        MyBean25C c = new MyBean25C();
        c.setName("손흥민");
        c.setCountry("대한민국");
        mapper.insert(c);
        System.out.println(c.getId());
    }
}
