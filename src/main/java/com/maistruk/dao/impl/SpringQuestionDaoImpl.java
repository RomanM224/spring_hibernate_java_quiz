package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.SpringQuestionDao;
import com.maistruk.model.spring.SpringQuestion;

@Repository
public class SpringQuestionDaoImpl implements SpringQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public void create(SpringQuestion springQuestion) {
        Session session = sessionFactory.getCurrentSession();
        session.save(springQuestion);
    }
    
    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public SpringQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (SpringQuestion) session.get(SpringQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from SpringQuestion").uniqueResult()).intValue();
    }


}
