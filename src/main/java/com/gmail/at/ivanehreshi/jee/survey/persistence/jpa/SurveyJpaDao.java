package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Survey;

public class SurveyJpaDao extends JpaDao<Survey, Long>{
    public SurveyJpaDao() {
        super(Survey.class);
    }

    @Override
    public Long create(Survey survey) {
        super.create(survey);
        return survey.getId();
    }
}
