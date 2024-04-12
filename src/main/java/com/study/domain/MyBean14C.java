package com.study.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyBean14C {
    private String address;

    public MyBean14C() {
    }

    public MyBean14C(String address) {
        this.address = address;
    }
}