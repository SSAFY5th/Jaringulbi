package com.ssafy.B303.model.dto;

public class UserDto {
    private int id;
    private String login_id;
    private String password;
    private String nickname;
    private int fish_count;
    private int budget;
    private String phone;
    private String image;

    public UserDto(String login_id, String password, String nickname, String phone) {
        this.login_id = login_id;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
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

    public int getFish_count() {
        return fish_count;
    }

    public void setFish_count(int fish_count) {
        this.fish_count = fish_count;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
