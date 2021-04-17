package com.empik.githubclient.entity;

public class UserInfo {
    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private String calculations;

    public UserInfo(String id, String login, String name, String type, String avatarUrl, String createdAt, String calculations) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculations;
    }
}
