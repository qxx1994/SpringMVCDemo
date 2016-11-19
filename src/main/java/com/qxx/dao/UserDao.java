package com.qxx.dao;

import com.qxx.model.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 24015 on 2016/11/3.
 */
public interface UserDao {

    int createUser(UserEntity user);

    int deleteUserById(long id);

    int updateUserInfo(UserEntity user);

    int updateUserPassword(UserEntity user);

    UserEntity getUserById(long id);

    List<UserEntity> getUserByNickname(String nickname);

    UserEntity getUserByUsername(String username);

    UserEntity getUserByLoginInfo(UserEntity user);

    List<UserEntity> getUsers(@Param("offset") int offset, @Param("limit") int limit);
}
