package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AdminQuestionnairesController extends UserQuestionnairesController {
    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    @PostConstruct
    public void update() {
        setQuestionnaires(questionnaireJpaDao.findAll());
    }

    public QuestionnaireJpaDao getQuestionnaireJpaDao() {
        return questionnaireJpaDao;
    }

    public void setQuestionnaireJpaDao(QuestionnaireJpaDao questionnaireJpaDao) {
        this.questionnaireJpaDao = questionnaireJpaDao;
    }
}
