package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Question;

import javax.ejb.Stateless;

@Stateless
public class QuestionJpaDao extends JpaDao<Question, Long>{

    public QuestionJpaDao() {
        super(Question.class);
    }

}
