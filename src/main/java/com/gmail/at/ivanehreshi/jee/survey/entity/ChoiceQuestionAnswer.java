package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class ChoiceQuestionAnswer extends Answer {

    public ChoiceQuestionAnswer() {
    }

    public ChoiceQuestionAnswer(String answer, FilledQuestionnaire filledQuestionnaire, Question question) {
        super(answer, filledQuestionnaire, question);
    }

    @Override
    public Integer decodedAnswer() {
        return null;
    }
}
