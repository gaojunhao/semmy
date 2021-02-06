package com.jay.entities;

public class User {
    private Integer id;
    private String phone;
    private String nickName;
    private String avatarUrl;
    private String province;
    private String city;

    public User(){}

    public User(Integer id, String phone, String nickName, String avatarUrl, String province, String city) {
        this.id = id;
        this.phone = phone;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.province = province;
        this.city = city;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"phone\":\"" + phone + '\"' +
                ", \"nickName\":\"" + nickName + '\"' +
                ", \"avatarUrl\":\"" + avatarUrl + '\"' +
                ", \"province\":\"" + province + '\"' +
                ", \"city\":\"" + city + '\"' +
                '}';
    }
}