package com.gmail.at.ivanehreshi.jee.survey.service;

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
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class AnswerViewerService {
    @EJB
    private FilledQuestionnaireDao filledQuestionnaireDao;

    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    @EJB
    private QuestionJpaDao questionJpaDao;

    private boolean fromNewer = true;

    private Long targetQuestionnaire;

    private Questionnaire questionnaire;
    private List<FilledQuestionnaire> filledQuestionnaires;
    private List<Question> questions;

    private Integer questionnaireCursor;
    private List<Answer> currentAnswers;

    @PostConstruct
    public void init() {
        targetQuestionnaire = 1L;
        questionnaireCursor = 1;

        update();
    }

    public void update() {
        long targetQuestionnaire;
        targetQuestionnaire = this.targetQuestionnaire;

        questionnaire = questionnaireJpaDao.read(targetQuestionnaire);
        if(questionnaire == null) {
            filledQuestionnaires = new ArrayList<>();
            currentAnswers = new ArrayList<>();
        } else {
            questions = questionJpaDao.findQuestionsByQuestionnaireId(questionnaire.getId());

            filledQuestionnaires = filledQuestionnaireDao.findFilledQuestionnaires(targetQuestionnaire);
            currentAnswers = filledQuestionnaireDao.findAnswers(getCurrentFilledQuestionnaire().getId());
        }
    }

    public Answer getAnswer(int i) {
        return getCurrentAnswers().get(i);
    }

    public void prev() {
        questionnaireCursor--;
        if(questionnaireCursor <= 0) {
            questionnaireCursor = filledQuestionnaires.size();
        }

        update();
    }

    public void next() {
        questionnaireCursor++;
        if(questionnaireCursor > filledQuestionnaires.size()) {
            questionnaireCursor = 1;
        }
        update();
    }

    public String getStringAnswer(int i) {
        Answer answer = getAnswer(i);
        Question q = questions.get(i);
        return q.decodeAnswer(answer.getAnswer());
    }

    public void changeOrder() {
        fromNewer = !fromNewer;
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
        this.filledQuestionnaires = filledQuestionnaires;
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
