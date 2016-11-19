package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.User;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.UserJpaDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserQuestionnairesController {
    @EJB
    private UserJpaDao userJpaDao;

    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    private Long userId;
    private User user;
    private List<Questionnaire> questionnaires;

    @PostConstruct
    public void init() {
        userId = 1L;
        update();
    }

    public void update() {
        user = userJpaDao.read(userId);
        questionnaires = userJpaDao.findUserQuestionnaires(userId);
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void deleteQuestionnaire(int index) {
        Questionnaire q = questionnaires.get(index);
        questionnaires.remove(index);
        questionnaireJpaDao.delete(q.getId());
    }

    public int countFilledQuestionnaires(Questionnaire q) {
        return questionnaireJpaDao.countFilledQuestionnaires(q.getId());
    }

    public String showLink(Questionnaire q) {
        return "questionnaire-created?faces-redirect=true&id=" + q.getId();
    }

    public String viewAnswers(Long questionnaireId) {
        return "answers?faces-redirect=true&q=" + questionnaireId;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
