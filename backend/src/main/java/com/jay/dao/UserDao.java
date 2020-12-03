package com.jay.dao;

import com.jay.entities.House;
import com.jay.entities.Logininfo;
import com.jay.entities.Tip;
import com.jay.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void setUser(@Param("id") int id, @Param("name")String name, @Param("addr") String addr);

    List<House> getAllHouses(@Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    void setHouses(House house);
    void registerhouser(@Param("op") String op, @Param("phone") String phone, @Param("name") String name, @Param("ads") String ads, @Param("pswd") String pswd, @Param("sex") String sex, @Param("uid") String uid, @Param("avasrc") String avasrc);
    void registerowner(@Param("op") String op, @Param("phone") String phone, @Param("name") String name, @Param("ads") String ads, @Param("pswd") String pswd, @Param("avasrc") String avasrc);

    Logininfo login(@Param("phone") String phone, @Param("pswd") String pswd, @Param("ident") String ident);

    House getonehouse(@Param("id") int id);

    List<Tip> getAllTips(@Param("itemcnt_start") int itemcnt_start, @Param("itemcnt_end") int itemcnt_end);

    Tip getOneTip(@Param("id") int id);

    void publish(Tip tip);

    void updateHouse(House house);

    void deleteHouse(@Param("id") int id, @Param("phone") String phone);
}