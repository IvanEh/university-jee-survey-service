package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {
    @Id
    private Long id;

    private String title;

    private boolean required;

    @ManyToOne
    private Questionnaire questionnaire;

    public Question() {
    }

    public Question(String title, Questionnaire questionnaire, boolean required) {
        this.questionnaire = questionnaire;
        this.required = required;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
        this.questionnaire.getQuestions().add(this);
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
