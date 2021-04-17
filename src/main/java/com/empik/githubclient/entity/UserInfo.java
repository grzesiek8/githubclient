package com.empik.githubclient.entity;

public class UserInfo {
    private final String id;
    private final String login;
    private final String name;
    private final String type;
    private final String avatarUrl;
    private final String createdAt;
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
