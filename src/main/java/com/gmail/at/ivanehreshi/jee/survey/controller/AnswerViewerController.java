package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.Answer;
import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.FilledQuestionnaireDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.util.ReverseViewList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class AnswerViewerController {
    @EJB
    private FilledQuestionnaireDao filledQuestionnaireDao;

    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    @EJB
    private QuestionJpaDao questionJpaDao;

    private Long targetQuestionnaire;

    private Questionnaire questionnaire;
    private ReverseViewList<FilledQuestionnaire> filledQuestionnaires;
    private List<Question> questions;

    private Integer questionnaireCursor = 1;
    private List<Answer> currentAnswers;

    public void init() {
        targetQuestionnaire = getTargetQuestionnaireParam();

        questionnaire = questionnaireJpaDao.read(targetQuestionnaire);
        if(questionnaire == null) {
            filledQuestionnaires = new ReverseViewList<>(new ArrayList<>());
            currentAnswers = new ArrayList<>();
        } else {
            questions = questionJpaDao.findQuestionsByQuestionnaireId(questionnaire.getId());

            filledQuestionnaires = new ReverseViewList<>(filledQuestionnaireDao.findFilledQuestionnaires(targetQuestionnaire));
            updateCurrentAnswers();
        }
    }

    public void updateCurrentAnswers() {
        if(filledQuestionnaires.isEmpty()) {
            return;
        }

        currentAnswers = filledQuestionnaireDao.findAnswers(getCurrentFilledQuestionnaire().getId());

    }

    public Answer getAnswer(int i) {
        return getCurrentAnswers().get(i);
    }

    public void prev() {
        if(filledQuestionnaires.isEmpty()) {
            return;
        }

        questionnaireCursor--;
        if(questionnaireCursor <= 0) {
            questionnaireCursor = filledQuestionnaires.size();
        }

        updateCurrentAnswers();
    }

    public void next() {
        if(filledQuestionnaires.isEmpty()) {
            return;
        }

        questionnaireCursor++;
        if(questionnaireCursor > filledQuestionnaires.size()) {
            questionnaireCursor = 1;
        }

        updateCurrentAnswers();
    }

    public void changeOrder() {
        filledQuestionnaires.reverse();
        updateCurrentAnswers();
    }

    public boolean isFromNewer() {
        return filledQuestionnaires.isReversed();
    }

    private Long getTargetQuestionnaireParam() {
        Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String s = requestParameterMap.get("q") ;
        return s == null ? null : Long.valueOf(s);
    }

    public List<Answer> getCurrentAnswers() {
        return currentAnswers;
    }

    public FilledQuestionnaire getCurrentFilledQuestionnaire() {
        return filledQuestionnaires.get(questionnaireCursor - 1);
    }

    public FilledQuestionnaireDao getFilledQuestionnaireDao() {
        return filledQuestionnaireDao;
    }

    public void setFilledQuestionnaireDao(FilledQuestionnaireDao filledQuestionnaireDao) {
        this.filledQuestionnaireDao = filledQuestionnaireDao;
    }

    public List<FilledQuestionnaire> getFilledQuestionnaires() {
        return filledQuestionnaires;
    }

    public void setFilledQuestionnaires(List<FilledQuestionnaire> filledQuestionnaires) {
        this.filledQuestionnaires = new ReverseViewList<>(filledQuestionnaires);
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Integer getQuestionnaireCursor() {
        return questionnaireCursor;
    }

    public void setQuestionnaireCursor(Integer questionnaireCursor) {
        this.questionnaireCursor = questionnaireCursor;
    }

    public QuestionnaireJpaDao getQuestionnaireJpaDao() {
        return questionnaireJpaDao;
    }

    public void setQuestionnaireJpaDao(QuestionnaireJpaDao questionnaireJpaDao) {
        this.questionnaireJpaDao = questionnaireJpaDao;
    }

    public Long getTargetQuestionnaire() {
        return targetQuestionnaire;
    }

    public void setTargetQuestionnaire(Long targetQuestionnaire) {
        this.targetQuestionnaire = targetQuestionnaire;
    }

    public QuestionJpaDao getQuestionJpaDao() {
        return questionJpaDao;
    }

    public void setQuestionJpaDao(QuestionJpaDao questionJpaDao) {
        this.questionJpaDao = questionJpaDao;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
