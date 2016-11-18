package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Answer;
import com.gmail.at.ivanehreshi.jee.survey.entity.FilledQuestionnaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FilledQuestionnaireDao extends JpaDao<FilledQuestionnaire, Long> {
    @EJB
    private QuestionnaireJpaDao questionnaireJpaDao;

    public FilledQuestionnaireDao() {
        super(FilledQuestionnaire.class);
    }

    @Override
    public Long create(FilledQuestionnaire filledQuestionnaire) {
        super.create(filledQuestionnaire);
        return filledQuestionnaire.getId();
    }

    public List<FilledQuestionnaire> findFilledQuestionnaires(Long questionnaireId) {
        List<FilledQuestionnaire> questionnaires = questionnaireJpaDao.read(questionnaireId).getFilledQuestionnaires();
        questionnaires.size();
        return questionnaires;
    }

    public QuestionnaireJpaDao getQuestionnaireJpaDao() {
        return questionnaireJpaDao;
    }

    public void setQuestionnaireJpaDao(QuestionnaireJpaDao questionnaireJpaDao) {
        this.questionnaireJpaDao = questionnaireJpaDao;
    }

    public List<Answer> findAnswers(Long id) {
        List<Answer> answers = read(id).getAnswers();
        answers.size();
        return answers;
    }
}
