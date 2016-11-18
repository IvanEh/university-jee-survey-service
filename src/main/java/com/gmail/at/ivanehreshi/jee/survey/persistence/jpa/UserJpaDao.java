package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserJpaDao extends JpaDao<User, Long> {

    public UserJpaDao() {
        super(User.class);
    }

    @Override
    public Long create(User user) {
        super.create(user);
        return user.getId();
    }

    public List<Questionnaire> findUserQuestionnaires(Long userId) {
        List<Questionnaire> questionnaires = read(userId).getQuestionnaires();
        questionnaires.size();
        return questionnaires;
    }
}
