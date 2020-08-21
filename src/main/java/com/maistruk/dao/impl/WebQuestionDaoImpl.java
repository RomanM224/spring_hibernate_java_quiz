package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.WebQuestionDao;
import com.maistruk.model.web.WebQuestion;

@Repository
public class WebQuestionDaoImpl implements WebQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public WebQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (WebQuestion) session.get(WebQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from WebQuestion").uniqueResult()).intValue();
    }
    
    
}
