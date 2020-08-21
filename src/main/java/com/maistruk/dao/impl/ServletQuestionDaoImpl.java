package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.ServletQuestionDao;
import com.maistruk.model.servlet.ServletQuestion;

@Repository
public class ServletQuestionDaoImpl implements ServletQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public ServletQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (ServletQuestion) session.get(ServletQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from ServletQuestion").uniqueResult()).intValue();
    }

}
