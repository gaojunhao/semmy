package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.entities.User;
import com.jay.service.UserService;
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
    public void setHouses(String phone, String ads, int maxg, String mtype, int rent, String img, int img_count) {
        userDao.setHouses(phone, ads, maxg, mtype, rent, img, img_count);
    }
}