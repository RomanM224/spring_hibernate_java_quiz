package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.JavaCoreAnswerDao;
import com.maistruk.model.java_core.JavaCoreAnswer;
import com.maistruk.model.spring.SpringAnswer;

@Repository
public class JavaCoreAnswerDaoImpl implements JavaCoreAnswerDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public JavaCoreAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (JavaCoreAnswer) session.get(JavaCoreAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from JavaCoreAnswer").uniqueResult()).intValue();
    }

}
