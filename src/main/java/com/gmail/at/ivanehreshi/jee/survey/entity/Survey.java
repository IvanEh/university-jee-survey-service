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

}
