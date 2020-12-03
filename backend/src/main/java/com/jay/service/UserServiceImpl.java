package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.entities.House;
import com.jay.entities.Logininfo;
import com.jay.entities.Tip;
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
    public void registerhouser(String op, String phone, String name, String ads, String pswd, String sex, String uid, String avasrc) { userDao.registerhouser(op, phone, name, ads, pswd, sex, uid, avasrc);}

    @Override
    public void registerowner(String op, String phone, String name, String ads, String pswd, String avasrc) { userDao.registerowner(op, phone, name, ads, pswd, avasrc);}

    @Override
    public Logininfo login(String phone, String pswd, String ident) {
        return userDao.login(phone, pswd, ident);
    }

    @Override
    public House getoneHouse(int id) {
        return userDao.getonehouse(id);
    }

    @Override
    public List<Tip> getAllTips(int itemcnt_start, int itemcnt_end) {
        return userDao.getAllTips(itemcnt_start, itemcnt_end);
    }

    @Override
    public Tip getOneTip(int id) {
        return userDao.getOneTip(id);
    }

    @Override
    public void publish(Tip tip) {
        userDao.publish(tip);
    }

    @Override
    public void updateHouse(House house) {
        userDao.updateHouse(house);
    }

    @Override
    public void deleteHouse(int id, String phone) {
        userDao.deleteHouse(id, phone);
    }

    @Override
    public List<House> getAllHouses(int itemcnt_start, int itemcnt_end) {
        return userDao.getAllHouses(itemcnt_start, itemcnt_end);
    }
}