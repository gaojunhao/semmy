package com.jay.service;

import com.jay.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void setUser(int id, String name, String addr);

    void setHouses(String phone, String ads, int maxg, String mtype, int rent, String img, int img_count);
}