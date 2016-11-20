package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FilledQuestionnaire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "filledQuestionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public FilledQuestionnaire() {
    }

    public FilledQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public void addAnswer(Answer a) {
        answers.add(a);
        a.setFilledQuestionnaire(this);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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

        if(Objects.isNull(questionnaire))
            return;

        if(!questionnaire.getFilledQuestionnaires().contains(this)) {
            questionnaire.getFilledQuestionnaires().add(this);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FilledQuestionnaire{" +
                "id=" + id +
                ", date=" + date +
                ", questionnaire=" + questionnaire.getId() +
                '}';
    }
}
