package com.gmail.at.ivanehreshi.jee.survey.util;

import com.gmail.at.ivanehreshi.jee.survey.entity.ChoiceQuestion;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.TextQuestion;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class QuestionHelper {
    public boolean isTextQuestion(Question question) {
        return question.getClass().equals(TextQuestion.class);
    }

    public boolean isChoiceQuestion(Question question) {
        return question.getClass().equals(ChoiceQuestion.class);
    }

    public ChoiceQuestion toChoiceQuestion(Question question) {
        return (ChoiceQuestion) question;
    }

    public TextQuestion toTextQuestion(TextQuestion textQuestion) {
        return (TextQuestion) textQuestion;
    }

}
