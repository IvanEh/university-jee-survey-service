package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FilledQuestionnaire {
    @Id
    private Long id;

    @ManyToOne
    private Survey survey;

    @OneToMany(mappedBy = "filledQuestionnaire")
    private List<Answer> answers;

}
