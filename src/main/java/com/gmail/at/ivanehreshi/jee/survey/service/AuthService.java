package com.gmail.at.ivanehreshi.jee.survey.service;

import com.gmail.at.ivanehreshi.jee.survey.entity.User;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.UserJpaDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.security.Principal;

@Named
@SessionScoped
public class AuthService implements Serializable {
    private static Logger LOGGER = LogManager.getLogger(AuthService.class);

    @EJB
    transient private UserJpaDao userJpaDao;

    private User currentUser = null;

    public User getCurrentUser() {
        if(currentUser == null) {
            Principal principal = getRequest().getUserPrincipal();
            if(principal == null) {
                return null;
            }

            currentUser = userJpaDao.findByUsername(principal.getName());
        }

        return currentUser;

    }

    public void logout() {
        currentUser = null;
        try {
            getRequest().logout();
        } catch (ServletException e) {
            LOGGER.warn("Cannot perform user logout", e);
        }
    }

    public boolean isAdmin() {
        return getRequest().isUserInRole("ADMIN");
    }

    public boolean isLoggedIn() {
        return getRequest().getUserPrincipal() != null;
    }

    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public UserJpaDao getUserJpaDao() {
        return userJpaDao;
    }

    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }
}
