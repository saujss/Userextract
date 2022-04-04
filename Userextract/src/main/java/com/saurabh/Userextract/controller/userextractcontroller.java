package com.saurabh.Userextract.controller;

import com.saurabh.Userextract.model.UserDto;
import com.saurabh.Userextract.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/userdata")
public class userextractcontroller {

    @Autowired
    private UserService userService;

    @GetMapping("/user-info")
    public ResponseEntity<List<UserDto>> getUserInfo() throws IOException {
        List<UserDto>  listUser ;
        listUser = userService.getUserDetails();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

    @PostMapping("/user-add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) throws IOException {
        UserDto userOutput = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(userOutput);

    }
}
