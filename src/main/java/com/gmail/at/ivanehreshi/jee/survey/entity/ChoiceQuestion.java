package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ChoiceQuestion extends Question {

    @ElementCollection(fetch = FetchType.EAGER)
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
    public Answer newAnswer() {
        Answer answer = new ChoiceQuestionAnswer();
        answer.setQuestion(this);
        return answer;
    }
}

