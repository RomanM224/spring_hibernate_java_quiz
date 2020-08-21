package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.JunitQuestionDao;
import com.maistruk.model.junit.JunitQuestion;

@Repository
public class JunitQuestionDaoImpl implements JunitQuestionDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public JunitQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (JunitQuestion) session.get(JunitQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from JunitQuestion").uniqueResult()).intValue();
    }

}
