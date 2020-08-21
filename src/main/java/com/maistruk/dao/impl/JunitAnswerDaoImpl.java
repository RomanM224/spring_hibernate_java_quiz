package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.JunitAnswerDao;
import com.maistruk.model.junit.JunitAnswer;

@Repository
public class JunitAnswerDaoImpl implements JunitAnswerDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public JunitAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (JunitAnswer) session.get(JunitAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from JunitAnswer").uniqueResult()).intValue();
    }

}
