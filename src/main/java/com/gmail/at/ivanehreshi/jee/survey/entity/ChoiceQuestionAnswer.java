package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class ChoiceQuestionAnswer extends Answer {

    @Override
    public Integer decodedAnswer() {
        return null;
    }
}
