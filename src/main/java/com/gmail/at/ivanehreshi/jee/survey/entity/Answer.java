package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Answer {
    @Id
    private Long id;

    @ManyToOne
    private FilledQuestionnaire filledQuestionnaire;

    @ManyToOne
    private Question question;

    private String answer;

    public Object decodedAnswer() {
        return answer;
    }
}
