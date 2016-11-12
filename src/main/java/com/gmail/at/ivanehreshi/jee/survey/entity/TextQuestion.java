package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.Entity;

@Entity
public class TextQuestion extends Question {
    private int maxLength;
}
