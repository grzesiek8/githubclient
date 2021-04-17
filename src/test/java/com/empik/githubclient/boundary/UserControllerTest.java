package com.empik.githubclient.boundary;

import com.empik.githubclient.control.UserService;
import com.empik.githubclient.entity.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUserInfo() throws Exception {
        //given
        UserInfo userInfo = new UserInfo("583231",
                "octocat",
                "The Octocat",
                "User",
                "https://avatars.githubusercontent.com/u/583231?v=4",
                "2011-01-25T18:44:36Z",
                "345.432532");

        //when
        when(userService.getUserInfo("octocat")).thenReturn(userInfo);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/users/octocat")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "    \"id\": \"583231\",\n" +
                        "    \"login\": \"octocat\",\n" +
                        "    \"name\": \"The Octocat\",\n" +
                        "    \"type\": \"User\",\n" +
                        "    \"avatarUrl\": \"https://avatars.githubusercontent.com/u/583231?v=4\",\n" +
                        "    \"createdAt\": \"2011-01-25T18:44:36Z\",\n" +
                        "    \"calculations\": \"345.432532\"\n" +
                        "}"));
    }
}