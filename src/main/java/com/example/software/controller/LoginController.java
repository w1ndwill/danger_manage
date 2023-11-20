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

import java.util.HashMap;
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

    @RequestMapping("/task") //映射到前端页面的URL
    public String getIndexPage() {
        return "manage_task"; //这里的字符串是前端页面的名称，Spring Boot将根据它返回前端页面
    }
    @RequestMapping("/巡查计划")
    public String showInspectionPlan() {
        return "login"; //返回与巡查计划相关的视图
    }

    @RequestMapping("/ts")
    public String showts() {
        return "ts";
    }

    @RequestMapping("/manager")
    public String main() {
        return "manager";
    }

    @RequestMapping("/company")
    public String company() {
        return "company";
    }

    @RequestMapping("/inspector")
    public String inspector() {
        return "inspector";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public ResponseEntity<?> loginIn(@RequestBody Map<String, String> request, HttpSession session) {
        String name = request.get("name");
        String password = request.get("password");
        System.out.println("name: " + name + ", password: " + password );
        // 从数据库中获取用户信息
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) { // 用户存在
            System.out.println("登录成功");
            session.setAttribute("user", userBean); // 将用户信息保存到Session中
            String page = "main";
            switch (userBean.getIdentity()) {
                case 1:
                    page = "inspector";
                    break;
                case 2:
                    page = "manager";
                    break;
                case 3:
                    page = "company";
                    break;
            }
            System.out.println("123");
            System.out.println("page: " + page);
            Map<String, Object> map = new HashMap<>();
            map.put("user", userBean);
            map.put("page", page);
            return ResponseEntity.ok(map); // 返回200状态码
        } else {
            System.out.println("登录失败");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build(); // 返回401状态码
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Map<String, String> request, HttpSession session) {
        String name = request.get("name1");
        String password = request.get("password");
        String truename = request.get("truename");
        String auth_code = request.get("auth_code");
        int identity = Integer.parseInt(request.get("identity"));
        System.out.println("接收到了");
        System.out.println("name: " + name + ", password: " + password + ", truename: " + truename + ", auth_code: " + auth_code + ", identity: " + identity);

        // 检查验证码和身份是否正确
        if (!checkAuthCode(auth_code, identity)) { // 验证码或身份不正确
            System.out.println("验证码或身份不正确");
            //返回验证码或身份不正确的信
            Map<String, String> map = Map.of("msg", "验证码或身份不正确");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(map);
        }
        //System.out.println("1");
        // 从数据库中获取用户信息
        boolean exists = userService.checkUserExists(name);
        if (!exists) {  // 用户不存在
            System.out.println("用户不存在");
            System.out.println("name: " + name + ", password: " + password + ", truename: " + truename + ", auth_code: " + auth_code + ", identity: " + identity);
            UserBean userBean= new UserBean(name,password,truename,identity);
            boolean success = userService.register(userBean);
            if (success) {
                System.out.println("注册成功");
                session.setAttribute("user", userBean); // 将用户信息保存到Session中
                return ResponseEntity.ok(userBean); // 返回200状态码
            } else {
                System.out.println("注册失败");
                //返回注册失败的信息
                Map<String, String> map = Map.of("msg", "注册失败");
                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(map); //返回401状态码
            }
        } else {
            System.out.println("用户已存在");
            //返回用户已存在的信息
            Map<String, String> map = Map.of("msg", "用户已存在");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(map); //返回401状态码
        }
    }

    private boolean checkAuthCode(String authCode, int identity) {
        return userService.checkAuthCode(authCode, identity);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(HttpSession session) {
        UserBean userBean = (UserBean) session.getAttribute("user");
        if (userBean != null) {
            return ResponseEntity.ok(userBean);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }
    }
}

