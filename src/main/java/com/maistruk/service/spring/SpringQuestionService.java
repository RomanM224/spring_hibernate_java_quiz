package com.maistruk.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.SpringQuestionDao;
import com.maistruk.model.spring.SpringQuestion;

@Service
public class SpringQuestionService {
    
    @Autowired
    private SpringQuestionDao springQuestionDao;
    
    public SpringQuestion getById(Integer id) {
        return springQuestionDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return springQuestionDao.getRowsAmount();
    }

}
