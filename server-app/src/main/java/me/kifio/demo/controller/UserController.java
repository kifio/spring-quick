package me.kifio.demo.controller;

import me.kifio.demo.model.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<User> user() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Content-Type", "application/json")
                .body(new User(
                        "Иван Мурашов",
                        UUID.randomUUID().toString()
                ));
    }

}
