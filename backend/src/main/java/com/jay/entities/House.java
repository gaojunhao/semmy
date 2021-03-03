package com.jay.entities;

public class House {
    private Integer id;
    private String phone;
    private Integer rent;
    private String zulintype;
    private String quyu;
    private String ditie;
    private String xiaoqu;
    private Integer louceng;
    private String fangjiantype;
    private String dianti;
    private Integer fangjiandaxiao;
    private String sex;
    private String fukuantype;
    private String contact;
    private String img;
    private Integer img_count;
    private String status;
    private String avasrc;
    private String location;

    public House(){}

    public House(Integer id, String phone, Integer rent, String zulintype, String quyu, String ditie, String xiaoqu, Integer louceng, String fangjiantype, String dianti, Integer fangjiandaxiao, String sex, String fukuantype, String contact, String img, Integer img_count, String status, String avasrc, String location) {
        this.id = id;
        this.phone = phone;
        this.rent = rent;
        this.zulintype = zulintype;
        this.quyu = quyu;
        this.ditie = ditie;
        this.xiaoqu =xiaoqu;
        this.louceng = louceng;
        this.fangjiantype = fangjiantype;
        this.dianti =dianti;
        this.fangjiandaxiao = fangjiandaxiao;
        this.sex =sex;
        this.fukuantype = fukuantype;
        this.contact = contact;
        this.img = img;
        this.img_count = img_count;
        this.status = status;
        this.avasrc = avasrc;
        this.location = location;
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

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getZulintype() {
        return zulintype;
    }

    public void setZulintype(String zulintype) {
        this.zulintype = zulintype;
    }

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu;
    }

    public String getDitie() {
        return ditie;
    }

    public void setDitie(String ditie) {
        this.ditie = ditie;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public Integer getLouceng() {
        return louceng;
    }

    public void setLouceng(Integer louceng) {
        this.louceng = louceng;
    }

    public String getFangjiantype() {
        return fangjiantype;
    }

    public void setFangjiantype(String fangjiantype) {
        this.fangjiantype = fangjiantype;
    }

    public String getDianti() {
        return dianti;
    }

    public void setDianti(String dianti) {
        this.dianti = dianti;
    }

    public Integer getFangjiandaxiao() {
        return fangjiandaxiao;
    }

    public void setFangjiandaxiao(Integer fangjiandaxiao) {
        this.fangjiandaxiao = fangjiandaxiao;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFukuantype() {
        return fukuantype;
    }

    public void setFukuantype(String fukuantype) {
        this.fukuantype = fukuantype;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public void setAvasrc(String avasrc) {
        this.avasrc = avasrc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"phone\":\"" + phone + '\"' +
                ", \"rent\":\"" + rent + '\"' +
                ", \"zulintype\":\"" + zulintype + '\"' +
                ", \"quyu\":\"" + quyu + '\"' +
                ", \"ditie\":\"" + ditie + '\"' +
                ", \"xiaoqu\":\"" + xiaoqu + '\"' +
                ", \"louceng\":\"" + louceng + '\"' +
                ", \"fangjiantype\":\"" + fangjiantype + '\"' +
                ", \"dianti\":\"" + dianti + '\"' +
                ", \"fangjiandaxiao\":\"" + fangjiandaxiao + '\"' +
                ", \"sex\":\"" + sex + '\"' +
                ", \"fukuantype\":\"" + fukuantype + '\"' +
                ", \"contact\":\"" + contact + '\"' +
                ", \"img\":\"" + img + '\"' +
                ", \"img_count\":\"" + img_count + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"avasrc\":\"" + avasrc + '\"' +
                ", \"location\":\"" + location + '\"' +
                '}';
    }
}
