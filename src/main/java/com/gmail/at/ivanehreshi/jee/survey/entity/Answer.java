package com.gmail.at.ivanehreshi.jee.survey.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Answer {
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

    public Object decodedAnswer() {
        return answer;
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
        this.filledQuestionnaire.getAnswers().add(this);
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
}
