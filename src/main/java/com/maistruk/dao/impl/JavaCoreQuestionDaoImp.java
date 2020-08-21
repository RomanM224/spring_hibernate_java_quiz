package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.JavaCoreQuestionDao;
import com.maistruk.model.java_core.JavaCoreQuestion;
import com.maistruk.model.spring.SpringQuestion;

@Repository
public class JavaCoreQuestionDaoImp implements JavaCoreQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public JavaCoreQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (JavaCoreQuestion) session.get(JavaCoreQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from JavaCoreQuestion").uniqueResult()).intValue();
    }

}
