package com.maistruk.service.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.MavenAnswerDao;
import com.maistruk.model.maven.MavenAnswer;

@Service
public class MavenAnswerService {
    
    @Autowired
    private MavenAnswerDao answerDao;
    
    public MavenAnswer getById(Integer id) {
        return answerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }


}
