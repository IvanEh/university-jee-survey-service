package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ChoiceQuestion extends Question implements Serializable {
    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn(name = "order_column")
    public List<String> choices = new ArrayList<>();

    public ChoiceQuestion() {
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    @Override
    public String decodeAnswer(String answer) {
        int index = Integer.valueOf(answer);

        if(index > choices.size() || index < 0) {
            return null;
        }

        return choices.get(index);
    }
}

