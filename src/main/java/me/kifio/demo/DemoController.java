package me.kifio.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

//    @RequestMapping("/home")
//    public String home(@RequestParam(required = false) String color,  Model page) {
//        page.addAttribute("username", "Katy");
//        page.addAttribute("color", color);
//        return "response.html";
//    }

    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color, Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", color);
        return "response.html";
    }
}
