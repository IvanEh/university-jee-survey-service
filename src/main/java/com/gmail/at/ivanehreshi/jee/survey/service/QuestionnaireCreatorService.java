package com.gmail.at.ivanehreshi.jee.survey.service;

import com.gmail.at.ivanehreshi.jee.survey.entity.ChoiceQuestion;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.TextQuestion;
import com.gmail.at.ivanehreshi.jee.survey.persistence.jpa.QuestionnaireJpaDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean
public class QuestionnaireCreatorService {
    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;
    private Questionnaire questionnaire = new Questionnaire();

    public void addTextQuestion() {
        questionnaire.addQuestion(new TextQuestion());
    }

    public void addChoiceQuestion() {
        questionnaire.addQuestion(new ChoiceQuestion());
    }

    public void addChoice(ChoiceQuestion choiceQuestion) {
        choiceQuestion.getChoices().add("");
    }

    public void removeQuestion(Question q) {
        System.out.println("remove q");
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

    public void save() {
        System.out.println(questionnaire.getQuestions().size());
        questionnaireJpaDao.create(questionnaire);
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
