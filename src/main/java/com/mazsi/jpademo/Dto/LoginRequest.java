package com.mazsi.jpademo.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginRequest { username: " + username +  ", password: " + password + " }";
    }
}
