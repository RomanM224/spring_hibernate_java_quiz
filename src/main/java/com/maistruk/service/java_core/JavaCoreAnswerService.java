package com.maistruk.service.java_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.JavaCoreAnswerDao;
import com.maistruk.model.java_core.JavaCoreAnswer;

@Service
public class JavaCoreAnswerService {
    
    @Autowired
    private JavaCoreAnswerDao javaCoreAnswerDao;
    
    public JavaCoreAnswer getById(Integer id) {
        return javaCoreAnswerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return javaCoreAnswerDao.getRowsAmount();
    }

}
