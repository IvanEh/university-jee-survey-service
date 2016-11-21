package com.gmail.at.ivanehreshi.jee.survey.controller;

import com.gmail.at.ivanehreshi.jee.survey.entity.*;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;
import com.gmail.at.ivanehreshi.jee.survey.service.AuthService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class QuestionnaireCreatorController {
    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    @Inject
    private AuthService authService;

    private Questionnaire questionnaire = new Questionnaire();

    public void addTextQuestion() {
        questionnaire.addQuestion(new TextQuestion());
    }

    public void addChoiceQuestion() {
        questionnaire.addQuestion(new ChoiceQuestion());
    }

    public void addCheckboxQuestion() {
        questionnaire.addQuestion(new CheckboxQuestion());
    }

    public void addChoice(ChoiceQuestion choiceQuestion) {
        choiceQuestion.getChoices().add("");
    }

    public void addCheckbox(CheckboxQuestion checkboxQuestion) {
        checkboxQuestion.getChoices().add("");
    }

    public void removeQuestion(Question q) {
        questionnaire.removeQuestion(q);
    }

    public boolean isTextQuestion(Question question) {
        return question.getClass().equals(TextQuestion.class);
    }

    public boolean isChoiceQuestion(Question question) {
        return question.getClass().equals(ChoiceQuestion.class);
    }

    public ChoiceQuestion toChoiceQuestion(Question question) {
        return (ChoiceQuestion) question;
    }

    public TextQuestion toTextQuestion(TextQuestion textQuestion) {
        return (TextQuestion) textQuestion;
    }

    public String save() {
        questionnaire.setAuthor(authService.getCurrentUser());
        questionnaireJpaDao.create(questionnaire);
        return "questionnaire-created?faces-redirect=true&id=" + questionnaire.getId();
    }

    public List<Question> getQuestions() {
        return questionnaire.getQuestions();
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
