package com.qxx.service;

import com.qxx.dao.UserDao;
import com.qxx.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 24015 on 2016/11/4.
 */
@Service
public class UserService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDao userDao;

    public int createUser(UserEntity user){
        return userDao.createUser(user);
    };

    public int deleteUserById(long id){
        return userDao.deleteUserById(id);
    };

    public int updateUserInfo(UserEntity user){
        return userDao.updateUserInfo(user);
    };

    public void updateUserPassword(UserEntity user){
        userDao.updateUserPassword(user);
    };

    public UserEntity getUserById(long id){
        UserEntity user = userDao.getUserById(id);
        return user;
    };

    public List<UserEntity> getUserByNickname(String nickname){
        List<UserEntity> users = userDao.getUserByNickname(nickname);
        return users;
    };

    public UserEntity getUserByUsername(String username){
        UserEntity user = userDao.getUserByUsername(username);
        return user;
    };

    public UserEntity getUserByLoginInfo(UserEntity user){
        UserEntity user2 = userDao.getUserByLoginInfo(user);
        return user2;
    };

    public List<UserEntity> getUsers(int offset,int limit){
        List<UserEntity> users = userDao.getUsers(offset,limit);
        return users;
    };
}
