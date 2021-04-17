package com.empik.githubclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUserInfo {
    @JsonProperty("id")
    private final int id;

    @JsonProperty("login")
    private final String login;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("type")
    private final String type;

    @JsonProperty("avatar_url")
    private final String avatarUrl;

    @JsonProperty("created_at")
    private final String createdAt;

    @JsonProperty("public_repos")
    private final int publicRepos;

    @JsonProperty("followers")
    private final int followers;

    public GithubUserInfo(int id, String login, String name, String type, String avatarUrl, String createdAt, int publicRepos, int followers) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.publicRepos = publicRepos;
        this.followers = followers;
    }
}
