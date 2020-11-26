package com.jay.service;

import com.jay.entities.House;
import com.jay.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void setUser(int id, String name, String addr);

    List<House> getAllHouses(int itemcnt_start, int itemcnt_end);

    void setHouses(House house);
}