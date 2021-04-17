package com.empik.githubclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    @JsonProperty("id")
    private final String id;

    @JsonProperty("login")
    private final String login;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("type")
    private final String type;

    @JsonProperty("avatarUrl")
    private final String avatarUrl;

    @JsonProperty("createdAt")
    private final String createdAt;

    @JsonProperty("calculations")
    private final String calculations;

    public UserInfo(String id, String login, String name, String type, String avatarUrl, String createdAt, String calculations) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculations;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCalculations() {
        return calculations;
    }
}
