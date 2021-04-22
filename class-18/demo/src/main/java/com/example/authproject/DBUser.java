package com.example.authproject;

import javax.persistence.*;

@Entity
public class DBUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    @Column(unique = true)
    private String username;
    private String authority;

    public DBUser(String username, String password, String authority) {
        this.password = password;
        this.username = username;
        this.authority = authority;
    }

    public DBUser(){

    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
