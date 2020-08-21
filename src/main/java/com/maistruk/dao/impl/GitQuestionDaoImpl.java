package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.GitQuestionDao;
import com.maistruk.model.git.GitQuestion;
import com.maistruk.model.java_core.JavaCoreQuestion;

@Repository
public class GitQuestionDaoImpl implements GitQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public GitQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (GitQuestion) session.get(GitQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from GitQuestion").uniqueResult()).intValue();
    }

}
