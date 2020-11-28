package com.jay.entities;

public class House {
    private Integer id;
    private String phone;
    private String ads;
    private Integer maxg;
    private String type;
    private Integer rent;
    private String img;
    private Integer img_count;
    private String status;
    private String avasrc;

    public House(){}

    public House(Integer id, String phone, String ads, Integer maxg, String type, Integer rent, String img, Integer img_count, String status, String avasrc) {
        this.id = id;
        this.phone = phone;
        this.ads = ads;
        this.maxg = maxg;
        this.type = type;
        this.rent = rent;
        this.img = img;
        this.img_count = img_count;
        this.status = status;
        this.avasrc = avasrc;
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

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public Integer getMaxg() {
        return maxg;
    }

    public void setMaxg(Integer maxg) {
        this.maxg = maxg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getImg_count() {
        return img_count;
    }

    public void setImg_count(Integer img_count) {
        this.img_count = img_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvasrc() {
        return avasrc;
    }

    public void setAvasrc(String status) {
        this.avasrc = avasrc;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"phone\":\"" + phone + '\"' +
                ", \"ads\":\"" + ads + '\"' +
                ", \"maxg\":\"" + maxg + '\"' +
                ", \"type\":\"" + type + '\"' +
                ", \"rent\":\"" + rent + '\"' +
                ", \"img\":\"" + img + '\"' +
                ", \"img_count\":\"" + img_count + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"avasrc\":\"" + avasrc + '\"' +
                '}';
    }
}
