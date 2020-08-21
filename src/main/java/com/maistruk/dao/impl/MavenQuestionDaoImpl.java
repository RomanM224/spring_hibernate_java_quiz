package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.MavenQuestionDao;
import com.maistruk.model.maven.MavenQuestion;

@Repository
public class MavenQuestionDaoImpl implements MavenQuestionDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public MavenQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (MavenQuestion) session.get(MavenQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from MavenQuestion").uniqueResult()).intValue();
    }

}
