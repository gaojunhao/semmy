package com.jay.service;

import com.jay.entities.House;
import com.jay.entities.Logininfo;
import com.jay.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void setUser(int id, String name, String addr);

    List<House> getAllHouses(int itemcnt_start, int itemcnt_end);

    void setHouses(House house);

    void registerhouser(String op, String phone, String name, String ads, String pswd, String sex, String uid, String avasrc);
    void registerowner(String op, String phone, String name, String ads, String pswd, String avasrc);

    Logininfo login(String phone, String pswd, String ident);

    House getoneHouse(int id);
}