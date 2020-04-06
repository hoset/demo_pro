package com.school.message.web.pojo;

public class UpdateUserInfo {
    private Long id;
    private String password;

    private String photoPath;

    private String birthday; // 生日
    private String nickname; // 昵称
    private String desc; // 签名


    private UserEmailInfo emailInfo;

    public UpdateUserInfo() {
    }

    public User toUser(){
        User user= new User();
        user.setId(id);
        user.setPhotoPath(photoPath);
        user.setBirthday(birthday);
        user.setNickname(nickname);
        user.setDesc(desc);
        user.setPassword(password);
        return user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserEmailInfo getEmailInfo() {
        return emailInfo;
    }

    public void setEmailInfo(UserEmailInfo emailInfo) {
        this.emailInfo = emailInfo;
    }


    @Override
    public String toString() {
        return "UpdateUserInfo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nickname='" + nickname + '\'' +
                ", desc='" + desc + '\'' +
                ", emailInfo=" + emailInfo +
                '}';
    }
}
