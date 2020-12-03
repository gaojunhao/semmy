package com.jay.controller;

import com.jay.entities.House;
import com.jay.entities.Logininfo;
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

    /**
     *返回user对象信息给page1.jsp处理，然后在前端页面展示
     */
    @RequestMapping("/page1")
    public ModelAndView getUser() {
        System.out.println("访问page1的后台。。。");
        ModelAndView mav = new ModelAndView("page1");
        List<User> users = service.getAllUser();
        System.out.println(users);
        mav.addObject("user", users.get(0));
        return mav;
//        return "page1"; //跳转到.jsp结尾的对应文件（page1.jsp）,此时返回值是String
    }

    /**
     * 直接返回字符串给请求的页面（这里在请求URL增加参数v是验证前后台通信是否正常）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/say", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sayHi(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("v");
        List<User> users = service.getAllUser();
        logger.info("{name:jay,context:hi,你好}");
        return users.toString();
    }

    @RequestMapping(value = "/set", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String setHi(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String addr = request.getParameter("address");
        service.setUser(id, name, addr);
        List<User> users = service.getAllUser();
        logger.info("{name:jay,context:set,你好}");
        return "-{name:jay,context:hi,你好}"+ users;
    }

    @RequestMapping(value = "/setjson", method = {RequestMethod.POST})
    @ResponseBody
    public String setjsonHi(@RequestBody Map map, HttpServletResponse response) {
        String id_str = (String) map.get("id");
        int id = Integer.parseInt(id_str);
        String name = (String) map.get("name");
        String addr = (String) map.get("address");
        service.setUser(id, name, addr);
        List<User> users = service.getAllUser();
        logger.info("{name:jay,context:set,你好}");
        return "-{name:jay,context:hi,你好}"+ users;
    }

    @RequestMapping(value = "/sethouses", method = {RequestMethod.POST})
    @ResponseBody
    public String sethouses(@RequestBody House house, HttpServletResponse response) {
        logger.info(house.getPhone());
        logger.info(house.getAvasrc());
        service.setHouses(house);
        return " set house success";
    }

    @RequestMapping(value = "/getAllhouses", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllhouses(HttpServletRequest request, HttpServletResponse response) {
        int itemcnt_start = Integer.parseInt(request.getParameter("itemcnt"));
        int itemcnt_end = 5;
        List<House> houses = service.getAllHouses(itemcnt_start, itemcnt_end);
        return houses.toString();
    }

    @RequestMapping(value = "/getonehouse", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getonehouse(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        House house = service.getoneHouse(id);
        return house.toString();
    }

    @RequestMapping(value = "/registerhouser", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String registerhouser(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String ads = request.getParameter("ads");
        String pswd = request.getParameter("pswd");
        String sex = request.getParameter("sex");
        String uid = request.getParameter("uid");
        String avasrc = request.getParameter("avasrc");
        service.registerhouser(op, phone, name, ads, pswd, sex, uid, avasrc);
        logger.info("{name:jay,context:set,你好}");
        return "-{name:jay,context:hi,你好}";
    }

    @RequestMapping(value = "/registerowner", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String registerowner(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String ads = request.getParameter("ads");
        String pswd = request.getParameter("pswd");
        String avasrc = request.getParameter("avasrc");
        service.registerowner(op, phone, name, ads, pswd, avasrc);
        logger.info("{name:jay,context:set,你好}");
        return "-{name:jay,context:hi,你好}";
    }

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String pswd = request.getParameter("pswd");
        String ident = request.getParameter("ident");
        String table = "";
        String host_str = "2";
        if (ident.equals(host_str))
            table = "owner";
        else
            table = "houser";
        logger.info(table);
        String rtval = "-2";
        Logininfo logininfo = service.login(phone, pswd, table);
        if (logininfo == null)
            rtval = "-1 ";
        else
            rtval = "1 ";
        return rtval + logininfo;
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
        //logger.info(house.getPhone());
        //logger.info(house.getAvasrc());
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
    public int deletehouse(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String phone = request.getParameter("phone");
        service.deleteHouse(id, phone);
        return 0;
    }

}