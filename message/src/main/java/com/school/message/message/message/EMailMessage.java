package com.school.message.message.message;

public class EMailMessage extends Message {
    private String username;
    private String password;
    private String host = "smtp.qq.com";
    private String protocol= "smtp";

    public EMailMessage() {
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
        return "EMailMessage{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", protocol='" + protocol + '\'' +
                "} " + super.toString();
    }
}
