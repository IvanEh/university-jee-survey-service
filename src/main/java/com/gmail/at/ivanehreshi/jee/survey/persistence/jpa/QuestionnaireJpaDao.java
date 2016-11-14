package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;

import javax.ejb.Stateless;

@Stateless
public class QuestionnaireJpaDao extends JpaDao<Questionnaire, Long>{

    public QuestionnaireJpaDao() {
        super(Questionnaire.class);
    }

    @Override
    public Long create(Questionnaire questionnaire) {
        super.create(questionnaire);
        return questionnaire.getId();
    }
}
