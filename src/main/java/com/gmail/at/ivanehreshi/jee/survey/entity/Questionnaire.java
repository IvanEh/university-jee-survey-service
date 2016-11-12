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
}
