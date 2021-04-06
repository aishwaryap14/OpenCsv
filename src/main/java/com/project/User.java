package com.project;

import com.opencsv.bean.CsvBindByName;

public class User {
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String phone;
    @CsvBindByName
    private String country;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
