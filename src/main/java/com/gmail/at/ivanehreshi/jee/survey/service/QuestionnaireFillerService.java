package com.gmail.at.ivanehreshi.jee.survey.service;

import com.gmail.at.ivanehreshi.jee.survey.entity.Answer;
import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.FilledQuestionnaireDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean
public class QuestionnaireFillerService {
    @EJB
    private QuestionnaireJpaDao questionnaireDao;

    @EJB
    private FilledQuestionnaireDao filledQuestionnaireDao;

    @EJB
    private QuestionJpaDao questionDao;

    private Long targetQuestionnaire = 4L;

    private List<Question> questions;

    private Questionnaire questionnaire;

    private FilledQuestionnaire filledQuestionnaire;

    public QuestionnaireFillerService() {
    }

    private void init() {
        questionnaire = questionnaireDao.read(targetQuestionnaire);
        questions = questionnaireDao.getQuestions(targetQuestionnaire);
        filledQuestionnaire = new FilledQuestionnaire();
        initFilledQuestionnaire();
    }

    public void updateTarget(Long id) {
        targetQuestionnaire = id;
        init();
    }

    private void initFilledQuestionnaire() {
        filledQuestionnaire.setQuestionnaire(new Questionnaire(targetQuestionnaire));

        System.out.println("q.size = " + getQuestions().size());
        for (Question q : getQuestions()) {
            filledQuestionnaire.addAnswer(q.newAnswer());
        }
        System.out.println("filledQuestionnaire.answer.size() " + filledQuestionnaire.getAnswers().size());
    }

    public void save() {
        System.out.println("save begin");
        System.out.println(filledQuestionnaire.getAnswers());
        System.out.println("length: " + filledQuestionnaire.getAnswers().size());
        System.out.println(filledQuestionnaire.getQuestionnaire().getQuestions());
        filledQuestionnaireDao.create(filledQuestionnaire);
        System.out.println("save end");
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
