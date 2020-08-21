package com.maistruk.service.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.JunitQuestionDao;
import com.maistruk.model.junit.JunitQuestion;

@Service
public class JunitQuestionService {
    
    @Autowired
    private JunitQuestionDao questionService;
    
    public JunitQuestion getById(Integer id) {
        return questionService.getById(id);
    }
    
    public Integer getRowsAmount() {
        return questionService.getRowsAmount();
    }

}
