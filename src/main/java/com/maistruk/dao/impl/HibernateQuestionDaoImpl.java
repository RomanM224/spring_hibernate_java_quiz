package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.HibernateQuestionDao;
import com.maistruk.model.git.GitQuestion;
import com.maistruk.model.hibernate.HibernateQuestion;

@Repository
public class HibernateQuestionDaoImpl implements HibernateQuestionDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public HibernateQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (HibernateQuestion) session.get(HibernateQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation=Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from HibernateQuestion").uniqueResult()).intValue();
    }

}
