package com.empik.githubclient.boundary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessageResponse {
    @JsonProperty("type")
    final String type = "error";
    @JsonProperty("code")
    int code;
    @JsonProperty("message")
    String message;

    public ErrorMessageResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

