package com.jay.service;

import com.jay.entities.House;
import com.jay.entities.Tip;
import com.jay.entities.User;

import java.util.List;

public interface UserService {

    List<House> getAllHouses(int itemcnt_start, int itemcnt_end, String quyu, String ditie, String fangjiantype, String zulintype, int price);

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

    int gethousenum(String phone);

    House getoneHousebyphone(String phone);

    void addcollect(User user);

    User getcollect(String phone);

    List<House> gethousebyid(String id_arr);
}