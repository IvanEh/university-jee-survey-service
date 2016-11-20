package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ChoiceQuestionAnswer extends Answer implements Serializable {

    public ChoiceQuestionAnswer() {
    }

    public ChoiceQuestionAnswer(String answer, FilledQuestionnaire filledQuestionnaire, Question question) {
        super(answer, filledQuestionnaire, question);
    }
}
