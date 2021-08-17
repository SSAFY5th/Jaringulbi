package com.ssafy.B303.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class AccountBookDto {
    private int id;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    private String date;
    private int price;
    private int category;
    private String used;
    private String contents;
    private int user_id;

    public AccountBookDto(){};

    public AccountBookDto(int id,String date, int price, int category, String used, String contents, int user_id) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.category = category;
        this.used = used;
        this.contents = contents;
        this.user_id = user_id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
