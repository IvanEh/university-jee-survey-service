package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CheckboxQuestion extends Question {
    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn(name = "order_column")
    private List<String> choices = new ArrayList<>();

    @Override
    public List<String> decodeAnswer(String answer) {
        String[] indices = answer.split(",");
        List<String> results = new ArrayList<>();

        for (String ind: indices) {
            try {
                int v = Integer.valueOf(ind);
                if(v >= choices.size()) {
                    continue;
                }

                results.add(choices.get(v));

            } catch (NumberFormatException e) {
                // TODO: Logger warning
            }

        }

        System.out.println(results);
        return results;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
