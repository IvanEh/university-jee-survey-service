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
}
