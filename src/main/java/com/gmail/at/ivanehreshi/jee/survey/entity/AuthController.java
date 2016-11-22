package com.gmail.at.ivanehreshi.jee.survey.entity;

import com.gmail.at.ivanehreshi.jee.survey.service.AuthService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class AuthController {
    @Inject
    private AuthService authService;

    public String logout() {
        authService.logout();
        return "home?faces-redirect=true";
    }
}
