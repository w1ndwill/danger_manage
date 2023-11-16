package com.example.software.controller;


import com.example.software.bean.UserBean;
import com.example.software.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/task") // 映射到前端页面的URL
    public String getIndexPage() {
        return "mytask"; // 这里的字符串是前端页面的名称，Spring Boot将根据它返回前端页面
    }
    @RequestMapping("/巡查计划")
    public String showInspectionPlan() {
        return "login"; // 返回与巡查计划相关的视图
    }
    @RequestMapping("/ts")
    public String showts() {
        return "ts";
    }

    @RequestMapping("/alltask")
    public String showt() {
        return "alltask";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public ResponseEntity<?> loginIn(@RequestBody Map<String, String> request, HttpSession session) {
        String name = request.get("name");
        String password = request.get("password");
        System.out.println("name: " + name + ", password: " + password);
        // 从数据库中获取用户信息
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) { // 用户存在
            System.out.println("登录成功");
            session.setAttribute("user", userBean); // 将用户信息保存到Session中
            return ResponseEntity.ok(userBean); // 返回200状态码
        } else {
            System.out.println("登录失败");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build(); // 返回401状态码
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String password = request.get("password");
        String account = request.get("account");
        System.out.println("name: " + name + ", password: " + password + ", account: " + account);
        // 从数据库中获取用户信息
        UserBean userBean = userService.register(name, password, account);
        if (userBean != null) { // 用户存在
            System.out.println("注册成功");
            return ResponseEntity.ok(userBean); // 返回200状态码
        } else {
            System.out.println("注册失败");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build(); // 返回401状态码
        }
    }
}

