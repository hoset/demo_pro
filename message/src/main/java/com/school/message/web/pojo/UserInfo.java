package com.school.message.web.pojo;

public class UserInfo {

    private Long id;
    private String username;
    private Integer role;
    private String photoPath;

    private String birthday; // 生日
    private String nickname; // 昵称
    private String desc; // 签名

    private String  email;


    public UserInfo() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", photoPath='" + photoPath + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nickname='" + nickname + '\'' +
                ", desc='" + desc + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
