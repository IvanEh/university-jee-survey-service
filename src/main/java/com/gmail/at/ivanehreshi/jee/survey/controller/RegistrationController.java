package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.User;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.UserJpaDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RegistrationController {
    @EJB
    private UserJpaDao userJpaDao;

    private User user = new User();

    public String register() {
        userJpaDao.create(user);
        return "login";
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
