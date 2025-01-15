package me.kifio.demo.model;

import me.kifio.demo.model.service.LoginUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private LoginUserManagementService loginUserManagementService;

    private String username;
    private String password;

    public LoginProcessor(LoginUserManagementService loginUserManagementService) {
        this.loginUserManagementService = loginUserManagementService;
    }

    public boolean login() {
        if("admin".equals(username) && "admin".equals(password)) {
            this.loginUserManagementService.setUsername(username);
            return true;
        }

        return false;
    }

    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
