package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.MavenAnswerDao;
import com.maistruk.model.maven.MavenAnswer;

@Repository
public class MavenAnswerDaoImpl implements MavenAnswerDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public MavenAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (MavenAnswer) session.get(MavenAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from MavenAnswer").uniqueResult()).intValue();
    }

}
