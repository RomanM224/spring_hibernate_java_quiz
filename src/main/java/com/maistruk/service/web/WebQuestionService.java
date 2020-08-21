package com.maistruk.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.WebQuestionDao;
import com.maistruk.model.web.WebQuestion;

@Service
public class WebQuestionService {
    
    @Autowired
    private WebQuestionDao questionDao;
    
    public WebQuestion getById(Integer id) {
        return questionDao.getById(id);
    }

    public Integer getRowsAmount() {
        return questionDao.getRowsAmount();
    }

}
