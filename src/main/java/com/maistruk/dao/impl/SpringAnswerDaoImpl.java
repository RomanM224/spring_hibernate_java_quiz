package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.SpringAnswerDao;
import com.maistruk.model.spring.SpringAnswer;
import com.maistruk.model.spring.SpringQuestion;

@Repository
public class SpringAnswerDaoImpl implements SpringAnswerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public void create(SpringAnswer springAnswer) {
        // TODO Auto-generated method stub

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public SpringAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (SpringAnswer) session.get(SpringAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from SpringAnswer").uniqueResult()).intValue();
    }

}
