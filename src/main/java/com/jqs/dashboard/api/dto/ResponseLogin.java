package com.jqs.dashboard.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseLogin {
    private String token;
    private String userName;
    private String role;

    public ResponseLogin(String token) {
        this.token = token;
    }

    public ResponseLogin(String token, String userName, String role) {
        this.token = token;
        this.userName = userName;
        this.role = role;
    }
}
