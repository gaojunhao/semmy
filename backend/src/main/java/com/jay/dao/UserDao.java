package com.jay.dao;

import com.jay.entities.House;
import com.jay.entities.Tip;
import com.jay.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    void registeruser(User user);

    List<House> getAllHouses(@Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    void setHouses(House house);

    House getonehouse(@Param("id") int id);

    List<Tip> getAllTips(@Param("itemcnt_start") int itemcnt_start, @Param("itemcnt_end") int itemcnt_end);

    Tip getOneTip(@Param("id") int id);

    void publish(Tip tip);

    void updateHouse(House house);

    void deleteHouse(@Param("id") int id, @Param("phone") String phone);

    void delOnetip(@Param("id") int id, @Param("phone") String phone);

    String getuserphone(String nickName);
}