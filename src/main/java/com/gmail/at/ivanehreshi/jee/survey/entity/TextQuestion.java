package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class TextQuestion extends Question {
    public TextQuestion() {
    }

    public TextQuestion(String title, int maxLength, Questionnaire questionnaire, boolean required) {
        super(title, questionnaire, required);
    }

    @Override
    public Answer newAnswer() {
        Answer answer = new TextQuestionAnswer();
        answer.setQuestion(this);
        return answer;
    }

    @Override
    public String decodeAnswer(String answer) {
        return answer;
    }
}
