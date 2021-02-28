package com.jay.controller;

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
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.AlgorithmParameters;
import java.security.Security;
import com.alibaba.fastjson.JSONObject;
import java.util.*;


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

    @RequestMapping(value = "/getphone", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public JSONObject getphone(HttpServletRequest request, HttpServletResponse response) {
        String session_key = request.getParameter("session_key");
        String encryptedData = request.getParameter("encryptedData");
        String iv = request.getParameter("iv");
        // 被加密的数据
        byte[] dataByte = Base64.getDecoder().decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.getDecoder().decode(session_key);
        // 偏移量
        byte[] ivByte = Base64.getDecoder().decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getAllhouses", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllhouses(HttpServletRequest request, HttpServletResponse response) {
        logger.info("###getAllhouses###");
        int itemcnt_start = Integer.parseInt(request.getParameter("itemcnt"));
        logger.info("before quyu");
        String quyu = request.getParameter("quyu");
        logger.info(quyu);
        logger.info("after quyu");
        String ditie = request.getParameter("ditie");
        logger.info(ditie);
        String fangjiantype = request.getParameter("fangjiantype");
        logger.info(fangjiantype);
        String zulintype = request.getParameter("zulintype");
        logger.info(zulintype);
        int itemcnt_end = 5;
        int price = -1;
        logger.info("before rent");
        String rent_str = request.getParameter("rent");
        if (rent_str != null) {
            int rent = Integer.parseInt(request.getParameter("rent"));
            logger.info("after rent");
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
        logger.info(price);
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
        logger.info("##gethousebyid");
        logger.info(id_arr);
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