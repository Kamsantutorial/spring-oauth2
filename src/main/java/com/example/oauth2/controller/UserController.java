package com.example.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author KAMSAN TUTORIAL
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String verify () {
        return "You can access resource server now!";
    }

}
