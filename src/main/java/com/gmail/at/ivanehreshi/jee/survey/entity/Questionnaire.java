package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Questionnaire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilledQuestionnaire> filledQuestionnaires = new ArrayList<>();

    @ManyToOne
    private User author;

    public Questionnaire() {
    }

    public Questionnaire(Long id) {
        this.id = id;
    }

    public Questionnaire(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuestionnaire(this);
    }

    public void removeQuestion(Question q) {
        q.setQuestionnaire(null);
        questions.remove(q);
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<FilledQuestionnaire> getFilledQuestionnaires() {
        return filledQuestionnaires;
    }

    public void setFilledQuestionnaires(List<FilledQuestionnaire> filledQuestionnaires) {
        this.filledQuestionnaires = filledQuestionnaires;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
