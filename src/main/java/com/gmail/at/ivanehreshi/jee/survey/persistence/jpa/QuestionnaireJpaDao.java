package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.Question;
import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;

import javax.ejb.Stateless;
import java.util.List;

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

    public List<Question> getQuestions(Long questionnaireId) {
        List<Question> questions = read(questionnaireId).getQuestions();
        questions.size();
        return questions;
    }

    public int countFilledQuestionnaires(Long questionnaireId) {
        List<FilledQuestionnaire> filledQuestionnaires =
                read(questionnaireId).getFilledQuestionnaires();

        return filledQuestionnaires.size();
    }
}
