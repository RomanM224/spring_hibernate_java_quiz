package com.maistruk.service.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.HibernateAnswerDao;
import com.maistruk.model.hibernate.HibernateAnswer;

@Service
public class HibernateAnswerService {
    
    @Autowired
    private HibernateAnswerDao answerDao;
    
    public HibernateAnswer getById(Integer id) {
        return answerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }

}
