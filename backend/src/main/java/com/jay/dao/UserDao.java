package com.jay.dao;

import com.jay.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void setUser(@Param("id") int id, @Param("name")String name, @Param("addr") String addr);
    void setHouses(@Param("phone") String phone, @Param("ads")String ads, @Param("maxg")int maxg, @Param("mtype") String mtype, @Param("rent")int rent, @Param("img")String img, @Param("img_count")int img_count);
}