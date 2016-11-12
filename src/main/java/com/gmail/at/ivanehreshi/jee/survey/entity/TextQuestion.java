package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class TextQuestion extends Question {
    private int maxLength;

    public TextQuestion() {
    }

    public TextQuestion(String title, int maxLength, Questionnaire questionnaire, boolean required) {
        super(title, questionnaire, required);
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
