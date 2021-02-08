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

    List<House> getAllHousesquyu(String quyu, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfang(String fangjiantype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHouseszulin(String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousespriceend(int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousespricestart(int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufang(String quyu, String fangjiantype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyuzulin(String quyu, String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyupriceend(String quyu, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyupricestart(String quyu, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfangzulin(String fangjiantype, String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfangpriceend(String fangjiantype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfangpricestart(String fangjiantype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHouseszulintypepriceend(String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHouseszulintypepricestart(String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufangzulin(String quyu, String fangjiantype, String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufangpriceend(String quyu, String fangjiantype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufangpricestart(String quyu, String fangjiantype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyuzulinpriceend(String quyu, String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyuzulinpricestart(String quyu, String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfangzulinpriceend(String fangjiantype, String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesfangzulinpricestart(String fangjiantype, String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufangzulinpriceend(String quyu, String fangjiantype, String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesquyufangzulinpricestart(String quyu, String fangjiantype, String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditie(String ditie, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefang(String quyu, String fangjiantype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiezulin(String quyu, String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiepriceend(String ditie, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiepricestart(String ditie, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefangzulin(String ditie, String fangjiantype, String zulintype, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefangpriceend(String ditie, String fangjiantype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefangpricestart(String ditie, String fangjiantype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiezulinpriceend(String ditie, String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiezulinpricestart(String ditie, String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefangzulinpriceend(String ditie, String fangjiantype, String zulintype, int price, int itemcnt_start, int itemcnt_end);

    List<House> getAllHousesditiefangzulinpricestart(String ditie, String fangjiantype, String zulintype, int price, int i, int itemcnt_start, int itemcnt_end);
}