package com.school.message.web.pojo;

public class UserEmailInfo {

    private Long userId;
    private String username;
    private String password;
    private String host = "smtp.qq.com";
    private String protocol ="smtp";


    public UserEmailInfo() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "UserEmailInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
