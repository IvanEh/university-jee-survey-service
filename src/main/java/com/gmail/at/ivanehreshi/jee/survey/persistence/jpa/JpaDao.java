package com.gmail.at.ivanehreshi.jee.survey.persistence.jpa;

import com.gmail.at.ivanehreshi.jee.survey.persistence.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class JpaDao<T, PK> implements Dao<T, PK> {
    private final Class<T> clazz;

    @PersistenceUnit(unitName = "survey-em")
    EntityManagerFactory emf;

    public JpaDao(Class<T> type) {
        this.clazz = type;
    }

    @Override
    public PK create(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();

        return null;
    }

    @Override
    public T read(PK id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        T t = em.find(clazz, id);

        em.getTransaction().commit();
        em.close();

        return t;
    }

    @Override
    public void update(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(PK id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.getReference(clazz, id));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb  = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery = criteriaQuery.select(root);

        List<T> entities = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        em.close();

        return entities;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}

