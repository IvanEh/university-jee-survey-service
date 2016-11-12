package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OrderColumn;
import java.util.List;

@Entity
public class ChoiceQuestion extends Question {

    @ElementCollection
    @OrderColumn
    public List<String> choices;

    public ChoiceQuestion() {
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}

