package com.qxx.model;

import java.util.Collection;

/**
 * Created by 24015 on 2016/11/2.
 */
public class UserEntity {
    private int id;
    private String nickname;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String salt;
    private Collection<BlogEntity> blogsById;

    private UserEntity(Builder builder){
        this.nickname = builder.nickname;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.salt = builder.salt;
    }

    public static class Builder{
        private String nickname;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String salt;
        public Builder(){
        }
        public Builder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }
        public Builder salt(String salt){
            this.salt = salt;
            return this;
        }
        public UserEntity build(){
            return new UserEntity(this);
        }
    }

    public UserEntity() {
    }

    public UserEntity(int id, String nickname, String username, String password, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public UserEntity(int id, String nickname, String username, String password, String firstName, String lastName, String email, String phone, Collection<BlogEntity> blogsById) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.blogsById = blogsById;
    }

    public UserEntity(int id, String nickname, String username, String password, String firstName, String lastName, String email, String phone, String salt, Collection<BlogEntity> blogsById) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.salt = salt;
        this.blogsById = blogsById;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<BlogEntity> getBlogsById() {
        return blogsById;
    }

    public void setBlogsById(Collection<BlogEntity> blogsById) {
        this.blogsById = blogsById;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", blogsById=" + blogsById +
                '}';
    }
}
