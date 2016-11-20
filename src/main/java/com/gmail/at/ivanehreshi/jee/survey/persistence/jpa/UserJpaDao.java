package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.entity.Questionnaire;
import com.gmail.at.ivanehreshi.jee.survey.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public User findByUsername(String username) {
        EntityManager em = getEmf().createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();

    }

    public List<Questionnaire> findUserQuestionnaires(Long userId) {
        List<Questionnaire> questionnaires = read(userId).getQuestionnaires();
        questionnaires.size();
        return questionnaires;
    }
}
