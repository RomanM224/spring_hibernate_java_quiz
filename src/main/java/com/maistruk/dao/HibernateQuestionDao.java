package com.maistruk.dao;

import com.maistruk.model.hibernate.HibernateQuestion;

public interface HibernateQuestionDao {

    HibernateQuestion getById(Integer id);

    Integer getRowsAmount();
}
