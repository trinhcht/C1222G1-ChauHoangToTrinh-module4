package com.example.spring_security.repository;

import com.example.spring_security.model.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
@Repository
@Transactional
public class AppUserDAORepository {
    private final EntityManager entityManager;
    public AppUserDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}