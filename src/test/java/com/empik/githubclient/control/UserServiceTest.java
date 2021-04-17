package com.empik.githubclient.control;

import com.empik.githubclient.entity.GithubUserInfo;
import com.empik.githubclient.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private RestTemplate githubRestTemplate;

    @Test
    void getUserInfo() {
        //given
        GithubUserInfo githubUserInfo = new GithubUserInfo(
                1,
                "octocat",
                "The Octocat",
                "User",
                "https://avatars.githubusercontent.com/u/583231?v=4",
                "2011-01-25T18:44:36Z",
                4,
                6
        );
        UserService userService = new UserService(githubRestTemplate);

        //when
        when(githubRestTemplate.getForObject(anyString(), eq(GithubUserInfo.class), anyString())).thenReturn(githubUserInfo);

        //then
        UserInfo userInfo = userService.getUserInfo("octocat");
        assertEquals(userInfo.getId(), "1");
        assertEquals(userInfo.getName(), "The Octocat");
        assertEquals(userInfo.getLogin(), "octocat");
        assertEquals(userInfo.getType(), "User");
        assertEquals(userInfo.getAvatarUrl(), "https://avatars.githubusercontent.com/u/583231?v=4");
        assertEquals(userInfo.getCreatedAt(), "2011-01-25T18:44:36Z");
        assertEquals(userInfo.getCalculations(), "6.0");
    }
}