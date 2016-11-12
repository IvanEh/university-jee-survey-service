package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class TextQuestionAnswer extends Answer {
    @Override
    public String decodedAnswer() {
        return null;
    }
}
