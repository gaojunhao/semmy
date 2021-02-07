package com.jay.service;

import com.jay.dao.UserDao;
import com.jay.entities.House;
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
    public void setHouses(House house) {
        userDao.setHouses(house);
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
    public void registeruser(User user) {
        userDao.registeruser(user);
    }

    @Override
    public String getuserphone(String nickName) {
        return userDao.getuserphone(nickName);
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
    public void delOneTip(int id, String phone) {
        userDao.delOnetip(id, phone);
    }

    @Override
    public List<House> getAllHouses(int itemcnt_start, int itemcnt_end, String quyu, String ditie, String fangjiantype, String zulintype, int price) {
        if (quyu != null && fangjiantype == null && zulintype == null && price == -1) {
            return userDao.getAllHousesquyu(quyu, itemcnt_start, itemcnt_end);
        } else if (quyu == null && fangjiantype != null && zulintype == null && price == -1) {
            return userDao.getAllHousesquyufang(quyu, fangjiantype, itemcnt_start, itemcnt_end);
        } else if (quyu == null && fangjiantype == null && zulintype != null && price == -1) {
            return userDao.getAllHousesquyuzulin(quyu, zulintype, itemcnt_start, itemcnt_end);
        } else if (quyu == null && fangjiantype == null && zulintype == null && price != -1) {

        } else if (quyu != null && fangjiantype != null && zulintype == null && price == -1) {

        } else if (quyu != null && fangjiantype == null && zulintype != null && price == -1) {

        } else if (quyu != null && fangjiantype == null && zulintype == null && price != -1) {

        } else if (quyu == null && fangjiantype != null && zulintype != null && price == -1) {

        } else if (quyu == null && fangjiantype != null && zulintype == null && price != -1) {

        } else if (quyu == null && fangjiantype == null && zulintype != null && price != -1) {

        } else if (quyu != null && fangjiantype != null && zulintype != null && price == -1) {

        } else if (quyu != null && fangjiantype != null && zulintype == null && price != -1) {

        } else if (quyu != null && fangjiantype == null && zulintype != null && price != -1) {

        } else if (quyu == null && fangjiantype != null && zulintype != null && price != -1) {

        } else if (quyu != null && fangjiantype != null && zulintype != null && price != -1) {

        } else if (ditie != null && fangjiantype == null && zulintype == null && price == -1) {

        } else if (ditie == null && fangjiantype != null && zulintype == null && price == -1) {

        } else if (ditie == null && fangjiantype == null && zulintype != null && price == -1) {

        } else if (ditie == null && fangjiantype == null && zulintype == null && price != -1) {

        } else if (ditie != null && fangjiantype != null && zulintype == null && price == -1) {

        } else if (ditie != null && fangjiantype == null && zulintype != null && price == -1) {

        } else if (ditie != null && fangjiantype == null && zulintype == null && price != -1) {

        } else if (ditie == null && fangjiantype != null && zulintype != null && price == -1) {

        } else if (ditie == null && fangjiantype != null && zulintype == null && price != -1) {

        } else if (ditie == null && fangjiantype == null && zulintype != null && price != -1) {

        } else if (ditie != null && fangjiantype != null && zulintype != null && price == -1) {

        } else if (ditie != null && fangjiantype != null && zulintype == null && price != -1) {

        } else if (ditie != null && fangjiantype == null && zulintype != null && price != -1) {

        } else if (ditie == null && fangjiantype != null && zulintype != null && price != -1) {

        } else if (ditie != null && fangjiantype != null && zulintype != null && price != -1) {

        }
            return userDao.getAllHouses(itemcnt_start, itemcnt_end);
    }
}