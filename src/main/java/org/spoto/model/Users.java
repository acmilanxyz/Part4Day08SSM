package org.spoto.model;

public class Users {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String userInfo;

    public Users() {
    }

    public Users(Integer id, String username, String password, String nickname, String userInfo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userInfo = userInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
