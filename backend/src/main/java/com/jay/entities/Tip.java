package com.jay.entities;

public class Tip {
    private Integer id;
    private String phone;
    private String text;
    private String date;
    private String name;

    public Tip(){}

    public Tip(Integer id, String phone, String text, String date, String name) {
        this.id = id;
        this.phone = phone;
        this.text = text;
        this.date = date;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"phone\":\"" + phone + '\"' +
                ", \"text\":\"" + text + '\"' +
                ", \"date\":\"" + date + '\"' +
                ", \"name\":\"" + name + '\"' +
                '}';
    }
}
