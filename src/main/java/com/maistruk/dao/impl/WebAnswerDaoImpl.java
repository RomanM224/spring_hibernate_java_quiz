package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.WebAnswerDao;
import com.maistruk.model.web.WebAnswer;

@Repository
public class WebAnswerDaoImpl implements WebAnswerDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public WebAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (WebAnswer) session.get(WebAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from WebAnswer").uniqueResult()).intValue();
    }

}
