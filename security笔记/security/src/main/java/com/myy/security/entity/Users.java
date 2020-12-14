package com.myy.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Users extends User {
    private long id;
    private String username;
    private  String password;
    private String desc;

    public Users(String username, String password, Collection<? extends GrantedAuthority> authorities, long id, String username1, String password1, String desc) {
        super(username, password, authorities);
        this.id = id;
        this.username = username1;
        this.password = password1;
        this.desc = desc;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
