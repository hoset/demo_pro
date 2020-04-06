package com.school.message.web.pojo;

public class User {
    private Long id;

    private String username; // 登陆名
    private String password; // 登录密码
    private Integer role;// 角色


    private String photoPath; // 头像地址
    private String birthday; // 生日
    private String nickname; // 昵称
    private String desc; // 签名

    private String mobilePhone; // 手机
    private String email; // 邮箱



    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", photoPath='" + photoPath + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nickname='" + nickname + '\'' +
                ", desc='" + desc + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
