package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.Answer;
import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.FilledQuestionnaireDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ViewScoped
@ManagedBean
public class QuestionnaireController {
    @EJB
    private QuestionnaireJpaDao questionnaireDao;

    @EJB
    private FilledQuestionnaireDao filledQuestionnaireDao;

    @EJB
    private QuestionJpaDao questionDao;

    private Long targetQuestionnaire;

    private List<Question> questions;

    private Questionnaire questionnaire;

    private FilledQuestionnaire filledQuestionnaire;

    public QuestionnaireController() {
    }

    @PostConstruct
    public void initBean() {
        updateTarget(getTargetQuestionnaire());
    }

    private void init() {
        questionnaire = questionnaireDao.read(targetQuestionnaire);
        questions = questionnaireDao.getQuestions(targetQuestionnaire);
        filledQuestionnaire = new FilledQuestionnaire();
        initFilledQuestionnaire();
    }

    public void updateTarget(Long id) {
        targetQuestionnaire = id;

        if(id == null)
            return;

        init();
    }

    public boolean isValidTest() {
        return targetQuestionnaire != null;
    }

    private void initFilledQuestionnaire() {
        filledQuestionnaire.setQuestionnaire(new Questionnaire(targetQuestionnaire));

        for (Question q : getQuestions()) {
            filledQuestionnaire.addAnswer(q.newAnswer());
        }
    }

    public String save() {
        filledQuestionnaireDao.create(filledQuestionnaire);
        return "questionnaire-success?faces-redirect=true";
    }

    private Long getTargetQuestionnaire() {
        Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String s = requestParameterMap.get("q") ;
        return s == null ? null : Long.valueOf(s);
    }

    public List<Answer> getAnswers() {
        return getFilledQuestionnaire().getAnswers();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public QuestionnaireJpaDao getQuestionnaireDao() {
        return questionnaireDao;
    }

    public void setQuestionnaireDao(QuestionnaireJpaDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    public FilledQuestionnaire getFilledQuestionnaire() {
        return filledQuestionnaire;
    }

    public void setFilledQuestionnaire(FilledQuestionnaire filledQuestionnaire) {
        this.filledQuestionnaire = filledQuestionnaire;
    }


}
