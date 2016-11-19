package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class AdminQuestionnairesController {
    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    private List<Questionnaire> questionnaires;

    @PostConstruct
    public void update() {
        questionnaires = questionnaireJpaDao.findAll();
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

    public String viewAnswers(Long questionnaireId) {
        return "answers?faces-redirect=true&q=" + questionnaireId;
    }
    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

}
