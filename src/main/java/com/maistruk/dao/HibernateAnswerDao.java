package com.maistruk.dao;

import com.maistruk.model.hibernate.HibernateAnswer;

public interface HibernateAnswerDao {

    HibernateAnswer getById(Integer id);

    Integer getRowsAmount();
}
