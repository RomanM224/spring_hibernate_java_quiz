package com.maistruk.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.WebAnswerDao;
import com.maistruk.model.web.WebAnswer;

@Service
public class WebAnswerService {
    
    @Autowired
    private WebAnswerDao answerDao;

    public WebAnswer getById(Integer id) {
        return answerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }

}
