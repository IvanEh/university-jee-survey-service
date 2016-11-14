package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Survey {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private Questionnaire questionnaire;

    private Date startDate;

    private Date endDate;

    private boolean closed;

    @OneToMany(mappedBy = "survey")
    private List<FilledQuestionnaire> filledQuestionnaires = new ArrayList<>();

    public Survey() {
    }

    public Survey(Questionnaire questionnaire, Date startDate, Date endDate, boolean closed) {
        this.questionnaire = questionnaire;
        this.questionnaire.getSurveys().add(this);

        this.startDate = startDate;
        this.endDate = endDate;
        this.closed = closed;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        this.questionnaire.getSurveys().add(this);
    }

    public List<FilledQuestionnaire> getFilledQuestionnaires() {
        return filledQuestionnaires;
    }

    public void setFilledQuestionnaires(List<FilledQuestionnaire> filledQuestionnaires) {
        this.filledQuestionnaires = filledQuestionnaires;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
