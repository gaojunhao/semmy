package com.jay.controller;

import com.jay.entities.Encrypt;
import com.jay.entities.House;
import com.jay.entities.Tip;
import com.jay.entities.User;
import com.jay.service.UserService;
import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.*;

import com.alibaba.fastjson.JSONObject;
import java.util.*;

import org.apache.commons.codec.binary.Base64;


@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private UserService service;

    @RequestMapping(value = "/sethouses", method = {RequestMethod.POST})
    @ResponseBody
    public String sethouses(@RequestBody House house, HttpServletResponse response) {
        service.setHouses(house);
        return " set house success";
}

    @RequestMapping(value = "/gethousenum", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String gethousenum(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        int housenum = service.gethousenum(phone);
        String housenum_str = Integer.toString(housenum);
        return "{" + "\"housenum\":\"" + housenum_str + "\"" + "}";
    }

    @RequestMapping(value = "/checkuserbyphone", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkuserbyphone(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        logger.info(phone);
        User user = service.getuser(phone);
        if(user == null)
            return "{" + "\"phone\":\"" + "null" + "\"" + "}";
        return user.toString();
    }

    @RequestMapping(value = "/getphone", method = {RequestMethod.POST})
    @ResponseBody
    public String getphone(@RequestBody Encrypt encrypt, HttpServletResponse response){
        String session_key = encrypt.getSession_key();
        String encryptedData = encrypt.getEncryptedData();
        String iv = encrypt.getIv();
        logger.info(session_key);
        logger.info(encryptedData);
        logger.info("iv");
        logger.info(iv);
        // 被加密的数据
        byte[] dataByte = Base64.decodeBase64(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decodeBase64(session_key);
        // 偏移量
        byte[] ivByte = Base64.decodeBase64(iv);
        logger.info("ivByte");
        logger.info(ivByte);
        String result = null;
        String AES = "AES";
        String AES_CBC_PADDING = "AES/CBC/PKCS7Padding";
        try {
            logger.info("start encrypt");
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyGenerator.getInstance(AES).init(128);
            AlgorithmParameters params = AlgorithmParameters.getInstance(AES);
            params.init(new IvParameterSpec(ivByte));
            Key key = new SecretKeySpec(keyByte, AES);
            Cipher cipher = Cipher.getInstance(AES_CBC_PADDING,"BC");
            cipher.init(Cipher.DECRYPT_MODE, key, params);
            result = new String(cipher.doFinal(dataByte));
            logger.info("end encrypt");
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getvideo", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getvideo(HttpServletRequest request, HttpServletResponse response) {
        int itemcnt_start = Integer.parseInt(request.getParameter("itemcnt"));
        String quyu = request.getParameter("quyu");
        String ditie = request.getParameter("ditie");
        String fangjiantype = request.getParameter("fangjiantype");
        String zulintype = request.getParameter("zulintype");
        int itemcnt_end = 3;
        int price = -1;
        String rent_str = request.getParameter("rent");
        if (rent_str != null) {
            int rent = Integer.parseInt(request.getParameter("rent"));
            if (rent == 1) {
                price = 0;
            } else if (rent == 2) {
                price = 1000;
            } else if (rent == 3) {
                price = 2000;
            } else if (rent == 4) {
                price = 3000;
            } else if (rent == 5) {
                price = 4000;
            } else if (rent == 6) {
                price = 5000;
            } else if (rent == 7) {
                price = 6000;
            } else if (rent == 8) {
                price = 7000;
            } else {
                price = -1;
            }
        }
        List<House> houses = service.getAllHouses(itemcnt_start, itemcnt_end, quyu, ditie, fangjiantype, zulintype, price);
        return houses.toString();
    }

    @RequestMapping(value = "/getAllhouses", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllhouses(HttpServletRequest request, HttpServletResponse response) {
        int itemcnt_start = Integer.parseInt(request.getParameter("itemcnt"));
        String quyu = request.getParameter("quyu");
        String ditie = request.getParameter("ditie");
        String fangjiantype = request.getParameter("fangjiantype");
        String zulintype = request.getParameter("zulintype");
        int itemcnt_end = 5;
        int price = -1;
        String rent_str = request.getParameter("rent");
        if (rent_str != null) {
            int rent = Integer.parseInt(request.getParameter("rent"));
            if (rent == 1) {
                price = 0;
            } else if (rent == 2) {
                price = 1000;
            } else if (rent == 3) {
                price = 2000;
            } else if (rent == 4) {
                price = 3000;
            } else if (rent == 5) {
                price = 4000;
            } else if (rent == 6) {
                price = 5000;
            } else if (rent == 7) {
                price = 6000;
            } else if (rent == 8) {
                price = 7000;
            } else {
                price = -1;
            }
        }
        List<House> houses = service.getAllHouses(itemcnt_start, itemcnt_end, quyu, ditie, fangjiantype, zulintype, price);
        return houses.toString();
    }

    @RequestMapping(value = "/getonehouse", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getonehouse(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        House house = service.getoneHouse(id);
        return house.toString();
    }

    @RequestMapping(value = "/gethousebyid", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String gethousebyid(HttpServletRequest request, HttpServletResponse response) {
        String id_arr = request.getParameter("id");
        List<House> houses = service.gethousebyid(id_arr);
        logger.info(houses.size());
        return houses.toString();
    }

    @RequestMapping(value = "/getonehousebyphone", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getonehousebyphone(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        House house = service.getoneHousebyphone(phone);
        if (house == null)
            return "{" + "\"id\":\"" + "-1" + "\"" + "}";
        return house.toString();
    }

    @RequestMapping(value = "/getuserphone", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getuserphone(HttpServletRequest request, HttpServletResponse response) {
        String nickName = request.getParameter("nickName");
        String phone = service.getuserphone(nickName);
        return phone;
    }

    @RequestMapping(value = "/registeruser", method = {RequestMethod.POST})
    @ResponseBody
    public String registeruser(@RequestBody User user, HttpServletResponse response) {
        service.registeruser(user);
        return "register user success";
    }

    @RequestMapping(value = "/containid", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String containid(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");
        User user = service.getcollect(phone);
        String collect = user.getCollect();
        HashSet<String> h1 = new HashSet<String>();
        for(int i=0;i<collect.split(",").length;i++){
            h1.add(collect.split(",")[i]);
        }
        if (h1.contains(id))
            return "{" + "\"result\":\"" + "true" + "\"" + "}";
        else
            return "{" + "\"result\":\"" + "false" + "\"" + "}";
    }

    @RequestMapping(value = "/getcollect", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getcollect(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        User user = service.getcollect(phone);
        String collect = user.getCollect();
        return "{" + "\"collect\":\"" + collect + "\"" + "}";
    }

    @RequestMapping(value = "/addcollect", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addcollect(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");
        User user = service.getcollect(phone);
        String collect = user.getCollect();
        if (collect.equals(""))
            collect = id;
        else
            collect = collect + ',' + id;
        user.setCollect(collect);
        service.addcollect(user);
        return "addcollect success";
    }

    @RequestMapping(value = "/delcollect", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delcollect(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");
        User user = service.getcollect(phone);
        String collect = user.getCollect();
        HashSet<String> h1 = new HashSet<String>();
        for(int i=0;i<collect.split(",").length;i++){
            h1.add(collect.split(",")[i]);
        }
        h1.remove(id);
        String new_coll = "";
        if (h1.isEmpty()) {
            new_coll = "";
        }else if (h1.size() == 1) {
            new_coll = h1.toArray(new String[1])[0];
        }else {
            for (String coll: h1) {
                h1.remove(coll);
                if (h1.isEmpty())
                    new_coll = new_coll + coll;
                else
                    new_coll = new_coll + coll + ",";
            }
        }
        user.setCollect(new_coll);
        service.addcollect(user);
        return "addcollect success";
    }

    @RequestMapping(value = "/getAllTips", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllTips(HttpServletRequest request, HttpServletResponse response) {
        int itemcnt_start = Integer.parseInt(request.getParameter("itemcnt"));
        int itemcnt_end = 10;
        List<Tip> tips = service.getAllTips(itemcnt_start, itemcnt_end);
        return tips.toString();
    }

    @RequestMapping(value = "/getOneTip", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getOneTip(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Tip tip = service.getOneTip(id);
        return tip.toString();
    }

    @RequestMapping(value = "/publish", method = {RequestMethod.POST})
    @ResponseBody
    public String publish(@RequestBody Tip tip, HttpServletResponse response) {
        service.publish(tip);
        return " publish tip success";
    }

    @RequestMapping(value = "/updatehouse", method = {RequestMethod.POST})
    @ResponseBody
    public Integer updatehouse(@RequestBody House house, HttpServletResponse response) {
        logger.info(house.getPhone());
        logger.info(house.getAvasrc());
        service.updateHouse(house);
        return house.getId();
    }

    @RequestMapping(value = "/deletehouse", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deletehouse(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String phone = request.getParameter("phone");
        logger.info("deletehouse...");
        logger.info(id);
        logger.info(phone);
        service.deleteHouse(id, phone);
        return "0";
    }

    @RequestMapping(value = "/delOneTip", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delOneTip(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String phone = request.getParameter("phone");
        service.delOneTip(id, phone);
        return "0";
    }

}