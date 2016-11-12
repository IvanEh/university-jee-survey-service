package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class TextQuestionAnswer extends Answer {

    public TextQuestionAnswer() {
    }

    public TextQuestionAnswer(String answer, FilledQuestionnaire filledQuestionnaire, Question question) {
        super(answer, filledQuestionnaire, question);
    }

    @Override
    public String decodedAnswer() {
        return null;
    }
}
