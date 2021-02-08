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
        int price_end = price + 1000;
        if (quyu != null && fangjiantype == null && zulintype == null && price == -1) {
            return userDao.getAllHousesquyu(quyu, itemcnt_start, itemcnt_end);
        } else if (quyu == null && ditie == null && fangjiantype != null && zulintype == null && price == -1) {
            return userDao.getAllHousesfang(fangjiantype, itemcnt_start, itemcnt_end);
        } else if (quyu == null && ditie == null && fangjiantype == null && zulintype != null && price == -1) {
            return userDao.getAllHouseszulin(zulintype, itemcnt_start, itemcnt_end);
        } else if (quyu == null && ditie == null && fangjiantype == null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousespriceend(price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousespricestart(price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu != null && fangjiantype != null && zulintype == null && price == -1) {
            return userDao.getAllHousesquyufang(quyu, fangjiantype, itemcnt_start, itemcnt_end);
        } else if (quyu != null && fangjiantype == null && zulintype != null && price == -1) {
            return userDao.getAllHousesquyuzulin(quyu, zulintype, itemcnt_start, itemcnt_end);
        } else if (quyu != null && fangjiantype == null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesquyupriceend(quyu, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesquyupricestart(quyu, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu == null && ditie == null && fangjiantype != null && zulintype != null && price == -1) {
            return userDao.getAllHousesfangzulin(fangjiantype, zulintype, itemcnt_start, itemcnt_end);
        } else if (quyu == null && ditie == null && fangjiantype != null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesfangpriceend(fangjiantype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesfangpricestart(fangjiantype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu == null && ditie == null && fangjiantype == null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHouseszulintypepriceend(zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHouseszulintypepricestart(zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu != null && fangjiantype != null && zulintype != null && price == -1) {
            return userDao.getAllHousesquyufangzulin(quyu, fangjiantype, zulintype, itemcnt_start, itemcnt_end);
        } else if (quyu != null && fangjiantype != null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesquyufangpriceend(quyu, fangjiantype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesquyufangpricestart(quyu, fangjiantype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu != null && fangjiantype == null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesquyuzulinpriceend(quyu, zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesquyuzulinpricestart(quyu, zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu == null && ditie == null && fangjiantype != null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesfangzulinpriceend(fangjiantype, zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesfangzulinpricestart(fangjiantype, zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu != null && fangjiantype != null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesquyufangzulinpriceend(quyu, fangjiantype, zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesquyufangzulinpricestart(quyu, fangjiantype, zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (ditie != null && fangjiantype == null && zulintype == null && price == -1) {
            return userDao.getAllHousesditie(ditie, itemcnt_start, itemcnt_end);
        } else if (ditie != null && fangjiantype != null && zulintype == null && price == -1) {
            return userDao.getAllHousesditiefang(ditie, fangjiantype, itemcnt_start, itemcnt_end);
        } else if (ditie != null && fangjiantype == null && zulintype != null && price == -1) {
            return userDao.getAllHousesditiezulin(ditie, zulintype, itemcnt_start, itemcnt_end);
        } else if (ditie != null && fangjiantype == null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesditiepriceend(ditie, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesditiepricestart(ditie, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (ditie != null && fangjiantype != null && zulintype != null && price == -1) {
            return userDao.getAllHousesditiefangzulin(ditie, fangjiantype, zulintype, itemcnt_start, itemcnt_end);
        } else if (ditie != null && fangjiantype != null && zulintype == null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesditiefangpriceend(ditie, fangjiantype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesditiefangpricestart(ditie, fangjiantype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (quyu != null && fangjiantype == null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesditiezulinpriceend(ditie, zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesditiezulinpricestart(ditie, zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        } else if (ditie != null && fangjiantype != null && zulintype != null && price != -1) {
            if (price == 8){
                return userDao.getAllHousesditiefangzulinpriceend(ditie, fangjiantype, zulintype, price, itemcnt_start, itemcnt_end);
            } else {
                return userDao.getAllHousesditiefangzulinpricestart(ditie, fangjiantype, zulintype, price, price_end, itemcnt_start, itemcnt_end);
            }
        }
            return userDao.getAllHouses(itemcnt_start, itemcnt_end);
    }
}