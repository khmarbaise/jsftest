package com.soebes.jsftest;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

/**
 * @author Karl Heinz Marbaise
 */
@ManagedBean(name = "loginManager")
@SessionScoped
public class LoginManager implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2087890675021805041L;

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
