package com.school.message.web.pojo;

import javax.validation.constraints.NotNull;

public class RegisterOrLogin {
    @NotNull
    private String username; // 登录名
    @NotNull
    private String password; // 登陆密码


    public RegisterOrLogin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterOrLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
