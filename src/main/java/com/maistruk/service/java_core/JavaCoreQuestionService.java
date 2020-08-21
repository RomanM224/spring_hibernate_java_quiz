package com.maistruk.service.java_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.JavaCoreQuestionDao;
import com.maistruk.model.java_core.JavaCoreQuestion;
import com.maistruk.model.spring.SpringQuestionAnswer;

@Service
public class JavaCoreQuestionService {

    @Autowired
    private JavaCoreQuestionDao javaCoreQuestionDao;
    
    public JavaCoreQuestion getById(Integer id) {
        return javaCoreQuestionDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return javaCoreQuestionDao.getRowsAmount();
    }
    
}
