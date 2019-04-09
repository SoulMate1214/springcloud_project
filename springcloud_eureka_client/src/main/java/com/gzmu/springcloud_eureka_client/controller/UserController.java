package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    final
    User user;

    @Autowired
    public UserController(User user) {
        this.user = user;
    }

    @RequestMapping("/user")
    public String index() {
        return user.toString();
    }
}

