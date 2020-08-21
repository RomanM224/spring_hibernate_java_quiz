package com.maistruk.service.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.ServletQuestionDao;
import com.maistruk.model.servlet.ServletQuestion;

@Service
public class ServletQuestionService {
    
    @Autowired
    private ServletQuestionDao questionDao;
    
    public ServletQuestion getById(Integer id) {
        return questionDao.getById(id);
    }

    public Integer getRowsAmount() {
        return questionDao.getRowsAmount();
    }

}
