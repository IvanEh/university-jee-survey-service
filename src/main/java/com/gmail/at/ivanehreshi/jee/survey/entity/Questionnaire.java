package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Questionnaire {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "questionnaire")
    private Set<Question> questions;

    @OneToMany(mappedBy = "questionnaire")
    private Set<Survey> surveys;

    public Questionnaire() {
    }

    public Questionnaire(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuestionnaire(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }
}
