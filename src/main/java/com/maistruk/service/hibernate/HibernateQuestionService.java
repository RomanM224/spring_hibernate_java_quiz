package com.maistruk.service.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.HibernateQuestionDao;
import com.maistruk.model.hibernate.HibernateQuestion;

@Service
public class HibernateQuestionService {
    
    @Autowired
    private HibernateQuestionDao questionDao;
    
    public HibernateQuestion getById(Integer id) {
        return questionDao.getById(id);
    }

    public Integer getRowsAmount() {
        return questionDao.getRowsAmount();
    }
}
