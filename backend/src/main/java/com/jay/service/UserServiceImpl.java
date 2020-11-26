package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.entities.House;
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
    public void setHouses(House house) {
        userDao.setHouses(house);
    }

    @Override
    public List<House> getAllHouses(int itemcnt_start, int itemcnt_end) {
        return userDao.getAllHouses(itemcnt_start, itemcnt_end);
    }
}