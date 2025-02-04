package com.jqs.dashboard.api;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
}
