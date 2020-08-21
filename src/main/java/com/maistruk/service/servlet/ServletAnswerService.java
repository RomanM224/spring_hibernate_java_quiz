package com.maistruk.service.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.ServletAnswerDao;
import com.maistruk.model.servlet.ServletAnswer;

@Service
public class ServletAnswerService {
    
    @Autowired
    private ServletAnswerDao answerDao;
    
    public ServletAnswer getById(Integer id) {
        return answerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }

}
