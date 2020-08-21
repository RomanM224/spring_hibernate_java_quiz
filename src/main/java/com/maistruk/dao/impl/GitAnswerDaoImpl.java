package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.GitAnswerDao;
import com.maistruk.model.git.GitAnswer;
import com.maistruk.model.java_core.JavaCoreAnswer;

@Repository
public class GitAnswerDaoImpl implements GitAnswerDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public GitAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (GitAnswer) session.get(GitAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from GitAnswer").uniqueResult()).intValue();
    }

}
