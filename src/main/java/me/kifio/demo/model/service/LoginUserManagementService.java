package me.kifio.demo.model.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoginUserManagementService {

    private String username;

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public boolean isLoggedIn() {
        return username != null;
    }

}
