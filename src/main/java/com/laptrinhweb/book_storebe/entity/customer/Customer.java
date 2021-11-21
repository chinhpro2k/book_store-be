package com.laptrinhweb.book_storebe.entity.customer;

import javax.persistence.*;


@MappedSuperclass
public class Customer {

   public String sex;
   public String username;
   public String password;
   public String name;
   public String date_of_birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
