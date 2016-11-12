package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;

public class FilledQuestionnaireDao extends JpaDao<FilledQuestionnaire, Long>{
    public FilledQuestionnaireDao() {
        super(FilledQuestionnaire.class);
    }

    @Override
    public Long create(FilledQuestionnaire filledQuestionnaire) {
        super.create(filledQuestionnaire);
        return filledQuestionnaire.getId();
    }
}
