package com.jay.service;

import com.jay.entities.House;
import com.jay.entities.Tip;
import com.jay.entities.User;

import java.util.List;

public interface UserService {

    List<House> getAllHouses(int itemcnt_start, int itemcnt_end);

    void setHouses(House house);

    House getoneHouse(int id);

    List<Tip> getAllTips(int itemcnt_start, int itemcnt_end);

    Tip getOneTip(int id);

    void publish(Tip tip);

    void updateHouse(House house);

    void deleteHouse(int id, String phone);

    void delOneTip(int id, String phone);

    void registeruser(User user);

    String getuserphone(String nickName);
}