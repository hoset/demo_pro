package com.school.message.web.pojo;

public class SendUser {
    private Long id;
    private Integer role;

    private String username;
    private String photoPath; // 头像地址
    private String desc;


    private String mobilePhone; // 手机
    private String weixin;//微信
    private String email; // 邮箱

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SendUser{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", desc='" + desc + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", weixin='" + weixin + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
