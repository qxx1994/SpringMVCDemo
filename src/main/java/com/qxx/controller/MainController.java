package com.qxx.controller;

import com.qxx.dao.UserDao;
import com.qxx.model.UserEntity;
import com.qxx.service.UserService;
import com.qxx.util.MD5Util;
import com.qxx.util.RSACryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.List;

/**
 * Created by 24015 on 2016/11/2.
 */
@Controller
public class MainController {
    private String str_privateKey;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        System.out.println("登录跳转");
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") UserEntity userEntity, ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("登录验证");
        try {
            HttpSession session = req.getSession();
            if (userEntity == null || session.getAttribute("publicKey") == null) {
                RSACryptoUtil.KeyPairOfString keyPairOfString = RSACryptoUtil.makeBothKeyOfString();
                String str_publicKey = keyPairOfString.getPublicKey();    //publicKey会发往客户端，将用户的密码加密
                str_privateKey = keyPairOfString.getPrivateKey();        //privateKey用于将接受到的加密后的密码进行解密
                session.setAttribute("publicKey", str_publicKey.replace("\n", ""));
                System.out.println("登录跳转");
                return "login/login";
            }
            String username = userEntity.getUsername();
            String password = userEntity.getPassword();
            if (username == null || "".equals(username) || password == null || "".equals(password)) {
                System.out.println("登录跳转");
                return "login/login";
            }

            UserEntity user = userService.getUserByUsername(userEntity.getUsername());
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) RSACryptoUtil.getPrivateKey(str_privateKey);
            String srcPassword = RSACryptoUtil.RSADecodeWithPrivateKey(rsaPrivateKey, password);
            String saltMD5 = MD5Util.string2MD5(user.getSalt());
            String passwordMD5 = MD5Util.string2MD5(saltMD5+"qxx"+srcPassword);
            if (user != null && user.getPassword().equals(passwordMD5)) {
                session.setAttribute("nickname",user.getNickname());
                if (user.getId() == 1) {
                    List<UserEntity> userList = userService.getUsers(0, 10);
                    modelMap.addAttribute("userList", userList);
                    System.out.println("用户管理跳转");
                    return "admin/users";
                } else {
                    userEntity = userService.getUserById(user.getId());
                    modelMap.addAttribute("user", userEntity);
                    System.out.println("用户详情跳转");
                    return "admin/userDetail";
                }
            }
            modelMap.addAttribute("user", userEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("登录跳转");
        return "login/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister(HttpServletRequest req){
        try {
            HttpSession session = req.getSession();
            System.out.println("注册跳转");
            RSACryptoUtil.KeyPairOfString keyPairOfString = RSACryptoUtil.makeBothKeyOfString();
            String str_publicKey = keyPairOfString.getPublicKey();    //publicKey会发往客户端，将用户的密码加密
            str_privateKey = keyPairOfString.getPrivateKey();        //privateKey用于将接受到的加密后的密码进行解密
            session.setAttribute("publicKey", str_publicKey.replace("\n", ""));
            return "login/register";
        }catch (Exception e){
            System.out.println("注册准备失败");
            e.printStackTrace();
        }
        return "login/login";
    }

    @RequestMapping(value = "/register/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserEntity userEntity, ModelMap modelMap){
        System.out.println("注册验证");
        String nickname = userEntity.getNickname();
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        do{
            if(str_privateKey == null || "".equals(str_privateKey))
                break;
            if(nickname == null || "".equals(nickname))
                break;
            if(username == null || "".equals(username))
                break;
            if(password == null || "".equals(password))
                break;
            try {
                Date date = new Date();
                RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) RSACryptoUtil.getPrivateKey(str_privateKey);
                String srcPassword = RSACryptoUtil.RSADecodeWithPrivateKey(rsaPrivateKey, password);
                String saltMD5 = MD5Util.string2MD5(date.toString());
                String passwordMD5 = MD5Util.string2MD5(saltMD5+"qxx"+srcPassword);
                UserEntity user = new UserEntity.Builder().nickname(nickname).username(username).password(passwordMD5).salt(date.toString()).build();
                int row = userService.createUser(user);
                if(row>0){
                    System.out.println("注册成功");
                    return "login/login";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while(false);
        System.out.println("登陆跳转");
        return "login/login";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        System.out.println("用户管理跳转");
        // 返回pages目录下的admin/users.jsp页面
        return "admin/users";
    }

    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userService.getUserById(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        System.out.println("用户详情跳转");
        return "admin/userDetail";
    }

    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId) {
        int rows = userService.deleteUserById(userId);
        System.out.println("用户管理跳转");
        return "admin/userDetail";
    }
}
