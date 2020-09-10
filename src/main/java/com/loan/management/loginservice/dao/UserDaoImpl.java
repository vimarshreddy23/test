package com.loan.management.loginservice.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.loan.management.loginservice.model.User;

public class UserDaoImpl {
	@Autowired
    private EntityManager em;

    public User save(User user) {
        Session session = em.unwrap(Session.class);
        session.persist(user);
       Transaction tx=session.beginTransaction();
       tx.commit();
     return user;
    }

}
