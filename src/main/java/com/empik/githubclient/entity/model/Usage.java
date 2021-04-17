package com.empik.githubclient.entity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "api_usage")
public class Usage {
    @Id
    private String login;

    private int requestCount;

    public Usage() { }

    public Usage(String login, int requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }
}