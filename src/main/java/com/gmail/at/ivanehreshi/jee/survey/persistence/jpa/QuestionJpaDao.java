package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Question;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class QuestionJpaDao extends JpaDao<Question, Long>{

    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    public QuestionJpaDao() {
        super(Question.class);
    }

    public List<Question> findQuestionsByQuestionnaireId(Long questionnaireId) {
        List<Question> questions = questionnaireJpaDao.read(questionnaireId).getQuestions();
        questions.size();
        return questions;
    }
}
