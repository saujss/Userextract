package com.saurabh.Userextract.services;

import com.saurabh.Userextract.model.UserDto;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public List<UserDto> getUserDetails() throws IOException;

    public UserDto addUser(UserDto user) throws IOException;
}

