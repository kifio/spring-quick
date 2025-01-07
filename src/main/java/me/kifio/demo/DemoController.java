package me.kifio.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/home")
    public String home() {
        return "response.html";
    }
}
