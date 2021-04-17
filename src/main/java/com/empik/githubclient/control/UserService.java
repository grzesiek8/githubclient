package com.empik.githubclient.control;

import com.empik.githubclient.entity.GithubUserInfo;
import com.empik.githubclient.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate githubRestTemplate;

    public UserService(RestTemplate githubRestTemplate) {
        this.githubRestTemplate = githubRestTemplate;
    }

    public UserInfo getUserInfo(String login) {
        GithubUserInfo githubUserInfo = githubRestTemplate.getForObject("/users/{login} ", GithubUserInfo.class, login);

        if (githubUserInfo == null) return null;

        return new UserInfo(
                Integer.toString(githubUserInfo.getId()),
                githubUserInfo.getLogin(),
                githubUserInfo.getName(),
                githubUserInfo.getType(),
                githubUserInfo.getAvatarUrl(),
                githubUserInfo.getCreatedAt(),
                this.doCalculations(githubUserInfo.getFollowers(), githubUserInfo.getPublicRepos())
        );
    }

    private String doCalculations(int followers, int publicRepos) {
        double result = 0.0;
        if (followers != 0) result = 6.0 / followers * (2 + publicRepos);
        return Double.toString(result);
    }
}