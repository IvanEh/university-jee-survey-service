package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class TextQuestionAnswer extends Answer implements Serializable{

    public TextQuestionAnswer() {
    }

    public TextQuestionAnswer(String answer, FilledQuestionnaire filledQuestionnaire, Question question) {
        super(answer, filledQuestionnaire, question);
    }
}
