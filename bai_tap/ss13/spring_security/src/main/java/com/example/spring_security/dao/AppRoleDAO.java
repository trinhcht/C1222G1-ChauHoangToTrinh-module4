package com.example.spring_security.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.example.spring_security.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class AppRoleDAO {
    @Autowired
    private EntityManager entityManager;
    public List<String> getRoleNames(Long userID) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userID = :userID ";
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userID", userID);
        return query.getResultList();
    }
}