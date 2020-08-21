package com.maistruk.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.SpringAnswerDao;
import com.maistruk.model.spring.SpringAnswer;

@Service
public class SpringAnswerService {
    
    @Autowired
    private SpringAnswerDao springAnswerDao;
    
    public SpringAnswer getById(Integer id) {
       return springAnswerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return springAnswerDao.getRowsAmount();
    }
    
    

}
