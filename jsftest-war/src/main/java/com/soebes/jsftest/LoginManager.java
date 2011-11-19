package com.soebes.jsftest;

import org.apache.log4j.Logger;

/**
 * @author Karl Heinz Marbaise
 */
public class LoginManager {
    private static Logger LOGGER = Logger.getLogger(LoginManager.class);

    private String username;
    private String password;

    public LoginManager() {
        LOGGER.info("LoginManager::LoginManager()");
    }

    public String loginAction() {
        LOGGER.info("loginAction()");
        String action = null;
        if (username.equalsIgnoreCase("kama") && password.equalsIgnoreCase("kama")) {
            action = "success";
        } else {
            action = "error";
        }
        return action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
