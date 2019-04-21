package com.redistest.model;

import java.io.Serializable;

/**
 * @Author: Administrator
 * @Date: 2019/4/20 0020 16:26
 * @Description:
 */
public class User implements Serializable {

    private String userName ;

    private String addr ;


    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", addr='" + addr + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
