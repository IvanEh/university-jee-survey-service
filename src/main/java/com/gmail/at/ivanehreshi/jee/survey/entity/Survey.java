package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Survey {
    @Id
    private Long id;

    @ManyToOne
    private Questionnaire questionnaire;

    private Date startDate;

    private Date endDate;

    private boolean closed;

    @OneToMany(mappedBy = "survey")
    private List<FilledQuestionnaire> questionnaires;

    public Survey() {
    }

    public Survey(Questionnaire questionnaire, Date startDate, Date endDate, boolean closed) {
        this.questionnaire = questionnaire;
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
    }

    public List<FilledQuestionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<FilledQuestionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
