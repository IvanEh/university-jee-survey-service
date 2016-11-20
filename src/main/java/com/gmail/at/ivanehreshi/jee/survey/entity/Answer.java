package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Answer implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private FilledQuestionnaire filledQuestionnaire;

    @ManyToOne
    private Question question;

    private String answer;

    public Answer() {
    }

    public Answer(String answer, FilledQuestionnaire filledQuestionnaire, Question question) {
        this.answer = answer;
        this.filledQuestionnaire = filledQuestionnaire;
        this.filledQuestionnaire.getAnswers().add(this);
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public FilledQuestionnaire getFilledQuestionnaire() {
        return filledQuestionnaire;
    }

    public void setFilledQuestionnaire(FilledQuestionnaire filledQuestionnaire) {
        this.filledQuestionnaire = filledQuestionnaire;

        if(Objects.isNull(filledQuestionnaire))
            return;

        if(!this.filledQuestionnaire.getAnswers().contains(this)) {
            this.filledQuestionnaire.getAnswers().add(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", id=" + id +
                ", question=" + question.getId() +
                ", filledQuestionnaire " + filledQuestionnaire.getId() +
                '}';
    }
}
