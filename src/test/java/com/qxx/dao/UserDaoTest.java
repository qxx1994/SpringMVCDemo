package com.qxx.dao;

import com.qxx.model.BlogEntity;
import com.qxx.model.UserEntity;
import com.qxx.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-dao.xml")
public class UserDaoTest {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDao userDao;
    @Test
    public void createUser(){
        userDao.createUser(new UserEntity.Builder().nickname("xiaohei").username("qxx2").password("qxx2").build());
    };

    @Test
    public void getUserByNickname(){
        List<UserEntity> users = userDao.getUserByNickname("xiaoming");
        for (UserEntity user:users
                ) {
            System.out.println(user);
        }
    };

    @Test
    public void getUsers(){
        List<UserEntity> users = userDao.getUsers(0,10);
        for (UserEntity user:users
             ) {
            System.out.println(user);
        }
    };

    @Test
    public void test(){
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.toString());
        String s1 = MD5Util.string2MD5(""+date.getTime());
        String s2 = MD5Util.string2MD5(""+date.toString());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(Math.pow(1d+1d/100000,100000d));
    };
}
