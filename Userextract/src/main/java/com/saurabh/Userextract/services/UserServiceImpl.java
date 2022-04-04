package com.saurabh.Userextract.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saurabh.Userextract.model.UserDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDto> getUserDetails() throws IOException {
        HttpGet get = new HttpGet("http://192.168.1.5:8080/getUser");

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(get);
        HttpEntity responseEntity = response.getEntity();

        ObjectMapper objectMapper = new ObjectMapper();
        List<UserDto> userDto = objectMapper.readValue(responseEntity.getContent(), new TypeReference<List<UserDto>>() {
        });
        return  userDto;
    }

    @Override
    public UserDto addUser(UserDto user) throws IOException {

        HttpPost post =  new HttpPost(  "http://192.168.1.5:8080/addUser");
        ObjectMapper objectMapper =  new ObjectMapper();
        HttpEntity entity = new StringEntity(objectMapper.writeValueAsString(user),"utf-8");
        post.addHeader("content-type","application/json");
        post.setEntity(entity);
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(post);
        HttpEntity responseEntity = response.getEntity();


        UserDto userout = objectMapper.readValue(responseEntity.getContent(), new TypeReference<UserDto>() {
        });
        return userout;
    }
}
