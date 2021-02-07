package com.jay.controller;

import com.jay.entities.House;
import com.jay.entities.Tip;
import com.jay.entities.User;
import com.jay.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


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
        int rent = Integer.parseInt(request.getParameter("rent"));
        if (rent == 1) {
            price = 0;
        } else if (rent == 2){
            price = 1000;
        } else if (rent == 3){
            price = 2000;
        } else if (rent == 4){
            price = 3000;
        } else if (rent == 5){
            price = 4000;
        } else if (rent == 6){
            price = 5000;
        } else if (rent == 7){
            price = 6000;
        } else if (rent == 8){
            price = 7000;
        } else {
            price = -1;
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
    public String updatehouse(@RequestBody House house, HttpServletResponse response) {
        logger.info(house.getPhone());
        logger.info(house.getAvasrc());
        service.updateHouse(house);
        return " update house success";
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