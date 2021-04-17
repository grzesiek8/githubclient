package com.empik.githubclient.boundary;

import com.empik.githubclient.control.UserService;
import com.empik.githubclient.entity.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{login}")
    ResponseEntity<UserInfo> getUser(@PathVariable String login) {
        UserInfo usInfo = userService.getUserInfo(login);
        return new ResponseEntity<>(usInfo, HttpStatus.OK);
    }
}