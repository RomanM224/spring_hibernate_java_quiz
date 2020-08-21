package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.SqlAnswerDao;
import com.maistruk.model.sql.SqlAnswer;

@Repository
public class SqlAnswerDaoImpl implements SqlAnswerDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public SqlAnswer getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (SqlAnswer) session.get(SqlAnswer.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from SqlAnswer").uniqueResult()).intValue();
    }

}
