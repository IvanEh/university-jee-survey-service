package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.User;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.UserJpaDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@ManagedBean
@ViewScoped
public class RegistrationController {
    @EJB
    private UserJpaDao userJpaDao;

    private User user = new User();

    public String register() {
        encodePassword(user);
        user.getRoles().add("USER");
        userJpaDao.create(user);
        return "login";
    }

    private void encodePassword(User user) {
        String password = user.getPassword();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] passwordBytes = password.getBytes();
        byte[] hash = md.digest(passwordBytes);
        String passwordHash =
                Base64.getEncoder().encodeToString(hash);

        user.setPassword(passwordHash);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserJpaDao getUserJpaDao() {
        return userJpaDao;
    }

    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }
}
