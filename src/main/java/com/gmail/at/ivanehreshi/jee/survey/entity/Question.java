package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private boolean required;

    @ManyToOne(optional = false)
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
        if(questionnaire != null && !questionnaire.getQuestions().contains(this)) {
            this.questionnaire.getQuestions().add(this);
        }
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

    public Answer newAnswer() {
        Answer answer = new Answer();
        answer.setQuestion(this);
        return answer;
    }

    public String decodeAnswer(String answer) {
        return null;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionnaire=" + questionnaire.getId() +
                ", id=" + id +
                ", required=" + required +
                ", title='" + title + '\'' +
                '}';
    }
}
