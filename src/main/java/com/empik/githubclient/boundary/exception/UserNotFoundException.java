package com.empik.githubclient.boundary.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String login) {
        super("User with login " + login + " not found");
    }
}