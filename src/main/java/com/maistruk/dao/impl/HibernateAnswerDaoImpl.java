package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.HibernateAnswerDao;
import com.maistruk.model.git.GitAnswer;
import com.maistruk.model.hibernate.HibernateAnswer;

@Repository
public class HibernateAnswerDaoImpl implements HibernateAnswerDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public HibernateAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (HibernateAnswer) session.get(HibernateAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from HibernateAnswer").uniqueResult()).intValue();
    }

}
