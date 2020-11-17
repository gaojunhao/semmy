package com.jay.dao;

import com.jay.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void setUser(@Param("id") int id, @Param("name")String name, @Param("addr") String addr);
}