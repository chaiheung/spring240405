package com.study.domain;

import java.util.List;

public class MyBean12B {
    private String name;
    private String team;
    private String country;
    private String event;
    private List<String> position;

    public MyBean12B() {
    }

    public MyBean12B(String name, String team, String country, String event, List<String> position) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.event = event;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }
}
