package com.example.software.controller;


import com.example.software.bean.UserBean;
import com.example.software.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    //将Service注入Web层1
    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/Index") // 映射到前端页面的URL
    public String getIndexPage() {
        return "Index"; // 这里的字符串是前端页面的名称，Spring Boot将根据它返回前端页面
    }
    @RequestMapping("/巡查计划")
    public String showInspectionPlan() {
        return "login"; // 返回与巡查计划相关的视图
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public ModelAndView login(String name, String password) {
        ModelAndView modelAndView = new ModelAndView();
        UserBean userBean = userService.loginIn(name, password);
        String tn = userService.getIdByUsernameAndPassword(name, password);
        modelAndView.addObject("tn", tn); // 将tn存储在Model中
        if (userBean != null) {
            modelAndView.setViewName("main");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }


}

