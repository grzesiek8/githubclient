package com.empik.githubclient.control;

import com.empik.githubclient.entity.UserInfo;
import org.springframework.web.client.RestTemplate;

public class UserService {

    private final RestTemplate githubRestTemplate;

    public UserService(RestTemplate githubRestTemplate) {
        this.githubRestTemplate = githubRestTemplate;
    }

    public UserInfo getUserInfo(String login) {
        return null;
    }
}
