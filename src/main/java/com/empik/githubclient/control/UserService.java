package com.empik.githubclient.control;

import com.empik.githubclient.boundary.exception.UserNotFoundException;
import com.empik.githubclient.entity.model.GithubUserInfo;
import com.empik.githubclient.entity.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final RestTemplate githubRestTemplate;
    private final UsageService usageService;

    public UserService(RestTemplate githubRestTemplate, UsageService usageService) {
        this.githubRestTemplate = githubRestTemplate;
        this.usageService = usageService;
    }

    public UserInfo getUserInfo(String login) throws UserNotFoundException {
        try {
            GithubUserInfo githubUserInfo = githubRestTemplate.getForObject("/users/{login} ", GithubUserInfo.class, login);
            if (githubUserInfo == null) return null;

            usageService.incrementUsageForLogin(login);
            return new UserInfo(
                    Integer.toString(githubUserInfo.getId()),
                    githubUserInfo.getLogin(),
                    githubUserInfo.getName(),
                    githubUserInfo.getType(),
                    githubUserInfo.getAvatarUrl(),
                    githubUserInfo.getCreatedAt(),
                    this.doCalculations(githubUserInfo.getFollowers(), githubUserInfo.getPublicRepos())
            );
        } catch (HttpClientErrorException exception) {
            throw new UserNotFoundException(login);
        }
    }

    private String doCalculations(int followers, int publicRepos) {
        double result = 0.0;
        if (followers != 0) result = 6.0 / followers * (2 + publicRepos);
        return Double.toString(result);
    }
}