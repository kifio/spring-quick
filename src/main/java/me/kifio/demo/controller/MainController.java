package me.kifio.demo.controller;

import me.kifio.demo.model.service.LoginUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoginUserManagementService loginUserManagementService;

    public MainController(LoginUserManagementService loginUserManagementService){
        this.loginUserManagementService = loginUserManagementService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if (logout != null) {
            loginUserManagementService.setUsername(null);
            return "redirect:/";
        }

        if (loginUserManagementService.isLoggedIn()) {
            return "main.html";
        }

        return "redirect:/";
    }
}
