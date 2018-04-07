package com.liuyis.demo.bean;

/**
 * Created by liuyis on 2018/4/7.
 */
public class Address {

    private String home;

    private String school;

    private User user;

    public Address(String home, String school, User user) {
        this.home = home;
        this.school = school;
        this.user = user;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
