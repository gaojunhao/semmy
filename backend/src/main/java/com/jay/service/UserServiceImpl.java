package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.entities.House;
import com.jay.entities.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public void setUser(int id, String name, String addr) {
        userDao.setUser(id, name, addr);
    }

    @Override
    public void setHouses(House house) {
        userDao.setHouses(house);
    }

    @Override
    public void registerhouser(String op, String phone, String name, String ads, String pswd, String sex, String uid) { userDao.registerhouser(op, phone, name, ads, pswd, sex, uid);}

    @Override
    public void registerowner(String op, String phone, String name, String ads, String pswd) { userDao.registerowner(op, phone, name, ads, pswd);}

    @Override
    public String login(String phone, String pswd, String ident) {
        return userDao.login(phone, pswd, ident);
    }

    @Override
    public List<House> getAllHouses(int itemcnt_start, int itemcnt_end) {
        return userDao.getAllHouses(itemcnt_start, itemcnt_end);
    }
}