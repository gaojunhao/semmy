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

    String getuserphone(@Param("nickName")String nickName);

    List<House> getAllHousesquyu(@Param("quyu")String quyu, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfang(@Param("fangjiantype")String fangjiantype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHouseszulin(@Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousespriceend(@Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousespricestart(@Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufang(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyuzulin(@Param("quyu")String quyu, @Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyupriceend(@Param("quyu")String quyu, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyupricestart(@Param("quyu")String quyu, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfangzulin(@Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfangpriceend(@Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfangpricestart(@Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHouseszulintypepriceend(@Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHouseszulintypepricestart(@Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufangzulin(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufangpriceend(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufangpricestart(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyuzulinpriceend(@Param("quyu")String quyu, @Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyuzulinpricestart(@Param("quyu")String quyu, @Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfangzulinpriceend(@Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesfangzulinpricestart(@Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufangzulinpriceend(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesquyufangzulinpricestart(@Param("quyu")String quyu, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditie(@Param("ditie")String ditie, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefang(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiezulin(@Param("ditie")String ditie, @Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiepriceend(@Param("ditie")String ditie, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiepricestart(@Param("ditie")String ditie, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefangzulin(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefangpriceend(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefangpricestart(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiezulinpriceend(@Param("ditie")String ditie, @Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiezulinpricestart(@Param("ditie")String ditie, @Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefangzulinpriceend(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);

    List<House> getAllHousesditiefangzulinpricestart(@Param("ditie")String ditie, @Param("fangjiantype")String fangjiantype, @Param("zulintype")String zulintype, @Param("price")int price, @Param("price_end")int price_end, @Param("itemcnt_start")int itemcnt_start, @Param("itemcnt_end")int itemcnt_end);
}