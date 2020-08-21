package com.maistruk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maistruk.dao.SqlQuestionDao;
import com.maistruk.model.sql.SqlQuestion;

@Repository
public class SqlQuestionDaoImpl implements SqlQuestionDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public SqlQuestion getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (SqlQuestion) session.get(SqlQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    public Integer getRowsAmount() {
        Session session = sessionFactory.getCurrentSession();
        return  ((Long) session.createQuery("select count(*) from SqlQuestion").uniqueResult()).intValue();
    }

}
